/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Classes.*;
import Controller.*;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author alejos17
 */
public class modelPedidos {
    
    private Control control;
    Database database;
    private LinkedList<clsPedidos> pedidoList = new LinkedList<>();  //Lista global que va guardando en el pedido los productos que selecciona el usuario.
    private LinkedList<clsPedidos> pedidosxCompList = new LinkedList<>();  //lista globarl que va guardando los pedidos simples despues de realizador por si se quiere crear un compuesto.
    private DefaultListModel model = new DefaultListModel();    //Model con la lista de productos en el pedido del cliente global para que vaya guardando fuera del metodo.
    private String idCliente;
    private String idCuenta;
    private String idcuenta1;
    private int idPedido;
    private double TotalPedido;
    private double TotalPedidoComp;
    private int tamLista;
    private int tamListapcomp;
    
    public modelPedidos() {
        this.database = new Database();
        
    }
    
    public String fecha(){
        Date fecha = new Date();
        String formatofecha = "YYYY-MM-dd HH:mm:ss";
        SimpleDateFormat fecha2 = new SimpleDateFormat(formatofecha);
        String fecha1 = fecha2.format(fecha);
        return fecha1;
    }
    
    public Timestamp fechaSQL(){
        Date fecha = new Date();
        Timestamp timestamp = new Timestamp(fecha.getTime());
        return timestamp;
    }
    
    //Crear Pedido, se envia desde la vista un Objeto Pedido y el codigo de cliente para preparar una lista de tipo Pedidos, con máx 20 items.
    public DefaultListModel CrearPedido(clsPedidos pedido, String idCliente1, String idCuenta1){
        idCliente = idCliente1;    //Se captura idcliente para asociarlo al pedido
        idCuenta = idCuenta1;    // Se captura idCuenta para el pago del pedido.
        try{
            if (pedidoList.size() < 20){   //Restriccion de 20 elementos por pedido simple
                pedidoList.add(pedido);     // Se guarda pedido capturado en la lista
                idPedido = Integer.parseInt(pedido.getIdPedido());
                double valorTotal = (double) pedido.getCantidad() * pedido.getValorunit(); //calculo de valor subtotal por cantidad de prodcuto seleccionado
                TotalPedido = TotalPedido + valorTotal;  //calculo del total del pedido completo
                tamLista = pedidoList.size();    //Indicador del tamaño de la lista para desplegar en la vista
                String data = pedido.getCantidad() +" - "+   pedido.getProducto()+" - "+ valorTotal;  // Generador de model para la lista de los items en el pedido.
                model.addElement(data);
            }else{
                control.PedidoMax();  //Aunque no funciona, me lanza el catch de este try para retornar un null. sin este no me funciona
                //En la vista, selecciono el mensaje de error si es por más de 20 productos o si es por inventario en cero.
            }
            
        }catch (Exception e){
            return null;
        }
        
        return model; 
            
    }
    
    //Borra el ultimo producto de la lista Pedido antes de Hacerlo
    public DefaultListModel BorrarProducto(){
        DefaultListModel model2 = new DefaultListModel();  
        try{
            pedidoList.removeLast();     // Se guarda pedido capturado en la lista
            TotalPedido = 0;   // Borra el total llevado por el pedido para volverlo a calcular de nuevo mas abajo.
            //Al quitar el ultimo elemento de la lista como resto a TotalPedido, para que muestre el total real.
            
            for (clsPedidos pedido : pedidoList){
                double valorTotal = (double) pedido.getCantidad() * pedido.getValorunit(); //calculo de valor subtotal por cantidad de prodcuto seleccionado
                TotalPedido = TotalPedido + valorTotal;  //Calcula el valor total del pedido recorriendo la lista
                String data = pedido.getCantidad() +" - "+   pedido.getProducto()+" - "+ valorTotal;  // Generador de model para la lista de los items en el pedido.
                model2.addElement(data);
            }
            
            model = model2;  //Reemplazo el model global con el nuevo model sin el ultimo producto.
            tamLista = pedidoList.size();    //Indicador del tamaño de la lista para desplegar en la vista
            
        }catch (Exception e){
            return null;
        }
        
        return model2; 
            
    }
    
    //Hacer Pedido - ingresar el pedido a la BD tanto en la tabla pedido
    //en la tabla inventariopedido con los valores calculados y restando las cantidades en inventario.
    //y en la tabla clientepedido para asignar ese pedido a ese cliente.
    public boolean HacerPedido(){
        int r = 0;
        
        //Primer TRY para guardar el pedido
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){
            String query1 = "INSERT INTO pedido (idpedido, producto, valortotal, cobrado, fecha) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statementPedido = conexion.prepareStatement(query1);  
            statementPedido.setInt(1, idPedido);  //Statements por cada ?
            statementPedido.setString(2, tamLista+"");
            statementPedido.setDouble(3, TotalPedido);
            statementPedido.setInt(4, 0);
            Timestamp fechaSQL = this.fechaSQL();   //LLamo metodo para calcular fecha en formato SQL
            statementPedido.setTimestamp(5, fechaSQL);
            int rowsInsertedPedido = statementPedido.executeUpdate();  //Se cuenta la cantiad de datos insertados en tabla Pedido
            if (rowsInsertedPedido > 0){
                    r = 1;
            }else{
                    r = 0;
            }
        conexion.close();  //Cierre de Conexiones para cada ciclo.
        statementPedido.close();
        }catch (Exception e){
            return false;
        }
        
        //Se recorre la lista de productos seleccionados para ingresarlos al pedido
        for (clsPedidos pedidos : pedidoList){ 
            try (Connection conexion = DriverManager.getConnection(database.getUrl())){           
                //Para la tabla inventariopedido
                String query2 = "INSERT INTO inventariopedido (id_pedido, id_inventario, fecha, cantidad, subtotal) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement statementInvPedido = conexion.prepareStatement(query2);  
                statementInvPedido.setInt(1, idPedido);
                statementInvPedido.setString(2, pedidos.getIdinventario());  
                Timestamp fechaSQL = this.fechaSQL();   //LLamo metodo para calcular fecha en formato SQL
                statementInvPedido.setTimestamp(3, fechaSQL);  //Envio parametro fecha
                statementInvPedido.setInt(4, pedidos.getCantidad());
                double valorTotal = (double) pedidos.getCantidad() * pedidos.getValorunit(); //Calcular el valor total en base a cantidad de producto
                statementInvPedido.setDouble(5, valorTotal);
                int rowsInsertedInvPedido = statementInvPedido.executeUpdate();  //Se cuenta la cantiad de datos insertados en tabla InventarioPedido
                //Update para la tabla inventario donde se resta la cantidad seleccionada por el usuario.
                int cantidad_final = pedidos.getCantinv() - pedidos.getCantidad();   // Resta la cantidad al inventario
                String query4 = "UPDATE inventario SET existencia = ? WHERE idinventario = ?";
                PreparedStatement statementInventario = conexion.prepareStatement(query4);
                statementInventario.setInt(1, cantidad_final);
                statementInventario.setString(2, pedidos.getIdinventario());
                int rowsInsertedInventario = statementInventario.executeUpdate();  //Se cuenta la cantiad de datos insertados en tabla InventarioPedido
                
                if (rowsInsertedInvPedido > 0){
                    if (rowsInsertedInventario > 0){
                        r = 1;
                    }    
                }else{
                    r = 0;
                }
            conexion.close();  //Cierre de Conexiones para cada ciclo.
            statementInvPedido.close();
            statementInventario.close();
            
            }catch (Exception e){
                return false;
            }
                
        }
        
        //Ingreso a la tabla clientePedido que es solo 1 registro, pedido por cliente
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){
            String query3 = "INSERT INTO clientepedido (id_cliente, id_pedido, fecha, id_cuenta) VALUES (?, ?, ?, ?)";
            PreparedStatement statementClientePedido = conexion.prepareStatement(query3);
            statementClientePedido.setString(1, idCliente);
            statementClientePedido.setInt(2, idPedido);
            Timestamp fechaSQL = this.fechaSQL();   //LLamo metodo para calcular fecha en formato SQL
            statementClientePedido.setTimestamp(3, fechaSQL);
            statementClientePedido.setString(4, idCuenta);
            int rowsInsertedClientePedido = statementClientePedido.executeUpdate();
            if (rowsInsertedClientePedido > 0){
                    r = 1;
            }else{
                    r = 0;
            }
        conexion.close();  //Cierre de Conexiones para cada ciclo.
        statementClientePedido.close();
        }catch (Exception e){
            return false;
        }
        this.LimpiarDatos();
        
        if (r == 1){
            return true;
        }else{
            return false;
        }
        
    }
    
    
    
    public boolean AgregarPedidoCompuesto(int idpcomp, String idcliente2){
        int r = 0;
        String guardar="No";
        tamListapcomp = pedidosxCompList.size();
        System.out.println("List TAM: "+tamListapcomp);
        System.out.println("List : "+pedidosxCompList);
        
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){
            String query1 = "INSERT INTO pedidocompuesto (idpcompuesto) VALUES (?)";
            PreparedStatement statementPedido = conexion.prepareStatement(query1);  
            statementPedido.setInt(1, idpcomp);  //Statements por cada ?
            int rowsInsertedPedido = statementPedido.executeUpdate();  //Se cuenta la cantiad de datos insertados en tabla Pedido
            if (rowsInsertedPedido > 0){
                r = 1;
            }else{
                r = 0;
            }
            conexion.close();  //Cierre de Conexiones para cada ciclo.
            statementPedido.close();
        }catch (Exception e){
            return false;
        }
        
        
        
        
        //Se recorre la lista de productos seleccionados para ingresarlos al pedido
        for (clsPedidos pedidos : pedidosxCompList){ 
            
            if (idcliente2.equals(pedidos.getIdCliente())){
                guardar = "Si";
                System.out.println(pedidos.getIdCliente());
                System.out.println(idpcomp);    
                System.out.println(pedidos.getIdPedido());
                System.out.println(pedidos.getIdCliente());
                System.out.println(pedidos.getIdCuenta());
                
                
                
                try (Connection conexion = DriverManager.getConnection(database.getUrl())){           
                            //Capturar el idcuenta del pedido ya que no lo tengo en el objeto
                    String query = "SELECT id_cuenta FROM clientepedido WHERE id_pedido = ?";
                    PreparedStatement statementCuenta1 = conexion.prepareStatement(query);
                    statementCuenta1.setString(1, pedidos.getIdPedido());  
                    ResultSet result = statementCuenta1.executeQuery();
                    while (result.next()){    
                        idcuenta1 = result.getString(1);
                    }
                    statementCuenta1.close();    
                    //Para la tabla inventariopedido
                    String query2 = "INSERT INTO clientepedidocomp (id_pcompuesto, id_pedido, id_cliente, id_cuenta, fecha) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement statementClientePedidoComp = conexion.prepareStatement(query2);  
                    statementClientePedidoComp.setInt(1, idpcomp);
                    statementClientePedidoComp.setInt(2, Integer.parseInt(pedidos.getIdPedido()));
                    statementClientePedidoComp.setString(3, pedidos.getIdCliente());  
                    statementClientePedidoComp.setString(4, idcuenta1);  
                    Timestamp fechaSQL = this.fechaSQL();   //LLamo metodo para calcular fecha en formato SQL
                    statementClientePedidoComp.setTimestamp(5, fechaSQL);  //Envio parametro fecha
                    int rowsInsertedClientePedidoComp = statementClientePedidoComp.executeUpdate();  //Se cuenta la cantiad de datos insertados en tabla InventarioPedido
                    //Update para la tabla inventario donde se resta la cantidad seleccionada por el usuario.


                    if (rowsInsertedClientePedidoComp > 0){
                        r = 1;
                    }else{
                        r = 0;
                    }
                conexion.close();  //Cierre de Conexiones para cada ciclo.
                statementClientePedidoComp.close();

                }catch (Exception e){
                    return false;
                }
            }else{
                guardar="No";
                return false;
            }    
        }
        
        
        switch (guardar){
            case "Si":
                try (Connection conexion = DriverManager.getConnection(database.getUrl())){
                    String query1 = "UPDATE pedidocompuesto SET pedidos = ?, valortotal = ?, cobrado = ?, fecha = ? WHERE idpcompuesto = ?";
                    PreparedStatement statementPedido = conexion.prepareStatement(query1);  
                    statementPedido.setInt(1, getTamListapcomp());
                    statementPedido.setDouble(2, getTotalPedidoComp());
                    statementPedido.setInt(3, 0);
                    Timestamp fechaSQL = this.fechaSQL();   //LLamo metodo para calcular fecha en formato SQL
                    statementPedido.setTimestamp(4, fechaSQL);
                    statementPedido.setInt(5, idpcomp);  //Statements por cada ?
                    int rowsInsertedPedido = statementPedido.executeUpdate();  //Se cuenta la cantiad de datos insertados en tabla Pedido
                    if (rowsInsertedPedido > 0){
                            r = 1;
                    }else{
                            r = 0;
                    }
                conexion.close();  //Cierre de Conexiones para cada ciclo.
                statementPedido.close();
                }catch (Exception e){
                    return false;
                }
                break;
            case "No":
                System.out.println("NO se guardo en pcompuesto por error");
        }
        
        pedidosxCompList.clear();
        tamListapcomp = 0;
        
        if (r == 1){
            return true;
        }else{
            return false;
        }
        
    }
    
    
    
    
    public void LimpiarDatos(){
        idCliente = "";
        idPedido = 0;
        TotalPedido = 0;
        tamLista = 0;
    }
    
    
    
    //Para borrar, lo unico que eso hace es al llamarlo desde la vista, mira que tipo de mascota es y llama según el caso a los metodos del modelo.
    public boolean BorrarPedido(clsPedidos pedido){
       
        return true;    
        
    }
    
    
    public clsPedidos Buscar(String idPedido){
        clsPedidos pedido1 = null;
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT p.idpedido, c2.id_cliente, c2.idcuenta, p.producto, p.valortotal FROM pedido p JOIN clientepedido c ON p.idpedido = c.id_pedido JOIN cuenta c2 ON c.id_cuenta = c2.idcuenta WHERE p.idpedido = ?";
            PreparedStatement statementBuscarPedido = conexion.prepareStatement(query);  //Preparando statement
            statementBuscarPedido.setString(1, idPedido);  //Statements en este caso le mando el codigo de usuario para busqueda
            ResultSet result = statementBuscarPedido.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idpedido = result.getString(1);
                String idcliente = result.getString(2);
                String idcuenta = result.getString(3);
                int listaproducto = result.getInt(4);
                int valorTotal = result.getInt(5);
                pedido1 = new clsPedidos(idpedido, null, 0, 0,0, valorTotal,0);
                pedido1.setIdCliente(idcliente);
                pedido1.setIdCuenta(idcuenta);
                pedido1.setTamListPedido(listaproducto);
            }
            return pedido1;
        }catch (Exception e){
            return pedido1;
        }
    }
    
    
    
    public DefaultListModel BuscarPedidoL(String idPedido){
        LinkedList<clsPedidos> pedidosBList = new LinkedList<>();
        DefaultListModel model = new DefaultListModel();
        clsPedidos pedido1 = null;
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT p.idpedido, ip.cantidad, i.producto, i.valorunitario, p.valortotal, c.id_cliente, c.fecha FROM inventario i JOIN inventariopedido ip ON i.idinventario = ip.id_inventario JOIN pedido p ON ip.id_pedido = p.idpedido JOIN clientepedido c on p.idpedido = c.id_pedido WHERE p.idpedido = ?";
            PreparedStatement statementBuscarPedido = conexion.prepareStatement(query);  //Preparando statement
            statementBuscarPedido.setString(1, idPedido);  //Statements en este caso le mando el codigo de usuario para busqueda
            ResultSet result = statementBuscarPedido.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idpedido = result.getString(1);
                int cantidad = result.getInt(2);
                String producto = result.getString(3);
                double valorunitario = result.getDouble(4);
                int valorTotal = result.getInt(5);
                String idcliente = result.getString(6);
                String fechapedido = result.getString(7);
                pedido1 = new clsPedidos(idpedido, producto, 0, 0,0,0,0);
                pedido1.setValorunit(valorunitario);
                pedido1.setValorTotal(valorTotal);
                pedido1.setCantidad(cantidad);
                pedido1.setIdCliente(idcliente);
                pedido1.setFecha(fechapedido);
                //TotalPedidoComp = getTotalPedidoComp() + valorTotal;
                pedidosBList.add(pedido1);
            }
        }catch (Exception e){
            return null;
        }
        
        //pedidosxCompList = (LinkedList) pedidosBList.clone();
        
        int index =0;
        //Modelo de lista model.
        for (clsPedidos pedido : pedidosBList){
            String data = pedido.getIdPedido() + " - "+ pedido.getCantidad() +" - "+ pedido.getProducto()+" - "+ pedido.getValorunit();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }
        return model; 
        
        
    }
    
    
    public DefaultListModel BuscarPedidoCompL(int idPcomp){
        LinkedList<clsPedidos> pedidosBList = new LinkedList<>();
        DefaultListModel model = new DefaultListModel();
        clsPedidos pedido1 = null;
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT pc.idpcompuesto, pc.pedidos, pc.valortotal, cpc.id_cliente, cpc.fecha FROM clientepedidocomp cpc JOIN pedidocompuesto pc ON cpc.id_pcompuesto = pc.idpcompuesto JOIN pedido p on p.idpedido = cpc.id_pedido WHERE pc.idpcompuesto = ?";
            PreparedStatement statementBuscarPedido = conexion.prepareStatement(query);  //Preparando statement
            statementBuscarPedido.setInt(1, idPcomp);  //Statements en este caso le mando el codigo de usuario para busqueda
            ResultSet result = statementBuscarPedido.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idpcompuesto = result.getString(1);
                String pedidos = result.getString(2);
                int valoTotal = result.getInt(3);
                String idcliente = result.getString(4);
                String fechapedidocomp = result.getString(5);
                pedido1 = new clsPedidos(idpcompuesto, pedidos, 0, 0,0,0,0);
                pedido1.setValorTotal(valoTotal);
                pedido1.setIdCliente(idcliente);
                pedido1.setFecha(fechapedidocomp);
                pedidosBList.add(pedido1);
            }
        }catch (Exception e){
            return null;
        }
        
        int index =0;
        //Modelo de lista model.
        for (clsPedidos pedido : pedidosBList){
            String data = pedido.getIdPedido() + " - "+ pedido.getCantidad() +" - "+ pedido.getProducto()+" - "+ pedido.getValorunit();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }
        return model; 
        
        
    }
    
    
    
    public DefaultListModel ListarPedidos(){
        LinkedList<clsPedidos> pedidosList = new LinkedList<>();
        DefaultListModel model = new DefaultListModel();
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT p.idpedido, c.fecha , p.producto, p.valortotal , c.id_cliente FROM pedido p JOIN  clientepedido c ON p.idpedido = c.id_pedido WHERE p.cobrado = 0";
            PreparedStatement statementListarPedidos = conexion.prepareStatement(query);  //Preparando statement
            ResultSet result = statementListarPedidos.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idpedido = result.getString(1);
                String fecha = result.getString(2);
                String productos = result.getString(3);
                int valorTotal  = result.getInt(4);
                String idcliente  = result.getString(5);
                clsPedidos pedido1 = new clsPedidos(idpedido,productos,0,0,0,valorTotal,0);
                pedido1.setFecha(result.getString(2));
                pedido1.setIdCliente(result.getString(5));
                TotalPedidoComp = getTotalPedidoComp() + valorTotal;
                pedidosList.add(pedido1);
                
            }
        }catch (Exception e){
            return null;
        }
        
        pedidosxCompList = (LinkedList) pedidosList.clone();
        
        int index =0;
        //Modelo de lista model.
        for (clsPedidos pedido : pedidosList){
            String data = pedido.getIdPedido() + " - "+ pedido.getFecha() +" - "+ pedido.getProducto()+" - "+pedido.getValorTotal()+" -- cliente: "+pedido.getIdCliente();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }
        return model;
    }
    
    
    public DefaultListModel ListarPedidosComp(){
        LinkedList<clsPedidos> pedidosList = new LinkedList<>();
        DefaultListModel model = new DefaultListModel();
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT p.idpcompuesto, p.fecha, p.pedidos, p.valortotal, c.id_cliente FROM pedidocompuesto p JOIN clientepedidocomp c ON p.idpcompuesto = c.id_pcompuesto WHERE p.cobrado = 0";
            PreparedStatement statementListarPedidos = conexion.prepareStatement(query);  //Preparando statement
            ResultSet result = statementListarPedidos.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idpedido = result.getString(1);
                String fecha = result.getString(2);
                String productos = result.getString(3);
                int valorTotal  = result.getInt(4);
                String idcliente  = result.getString(5);
                clsPedidos pedido1 = new clsPedidos(idpedido,productos,0,0,0,valorTotal,0);
                pedido1.setFecha(result.getString(2));
                pedido1.setIdCliente(result.getString(5));
                pedidosList.add(pedido1);
                
            }
        }catch (Exception e){
            return null;
        }
        
        int index =0;
        //Modelo de lista model.
        for (clsPedidos pedido : pedidosList){
            String data = pedido.getIdPedido() + " - "+ pedido.getFecha() +" - "+ pedido.getProducto()+" - "+pedido.getValorTotal()+" -- cliente: "+pedido.getIdCliente();
            model.add(index, data);  //Agrega cada cliente al modelo para aplicar a la lista
            index++;
        }
        return model;
    }
    
    
    public DefaultComboBoxModel ListarComboBoxCuentaPedido(String code){
        LinkedList<clsCuentas> cuentasList = new LinkedList<>();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        try (Connection conexion = DriverManager.getConnection(database.getUrl())){   //Al colocar la conexión dentro del parentesis del try, si hay un error o se termina el try la conexion se cierra.
            String query = "SELECT idcuenta FROM cuenta INNER JOIN cliente as c on id_cliente = c.idcliente WHERE id_cliente = ?";
            PreparedStatement statementCuentas = conexion.prepareStatement(query);  //Preparando statement
            statementCuentas.setString(1, code);
            ResultSet result = statementCuentas.executeQuery();
            while (result.next()){    //Ciclo al result set para sacar cada uno de los resultados en variables para crear el objeto y retornarlo.
                String idcuenta = result.getString(1);
                clsCuentas cuentas1 = new clsCuentas(idcuenta, null, 0, null);
                cuentasList.add(cuentas1);
            }
        }catch (Exception e){
            return null;
        }
        
        int index =0;
        //Modelo de lista model.
        for (clsCuentas cuenta : cuentasList){
            String data = cuenta.getIdCuenta();
            model.addElement(data);
            index++;
        }
        return model;
    }

    /**
     * @return the TotalPedido
     */
    public double getTotalPedido() {
        return TotalPedido;
    }

    /**
     * @return the tamLista
     */
    public int getTamLista() {
        return tamLista;
    }

    /**
     * @return the TotalPedidoComp
     */
    public double getTotalPedidoComp() {
        return TotalPedidoComp;
    }

    /**
     * @return the tamListapcomp
     */
    public int getTamListapcomp() {
        return tamListapcomp;
    }
    
    
    
    
    
    
    
    
    
}
