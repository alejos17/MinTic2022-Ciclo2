/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Classes.*;
import Controller.ctlPet;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author alejos17
 */
public class frmPet extends javax.swing.JFrame {
    
    ctlPet ctlPet = new ctlPet();  //Instancia entre el controller y la vista
    LinkedList<clsDog> dogObjectList = new LinkedList<>();  //Lista para guardar los objetos creados
    
    /**
     * Creates new form frmPet
     */
    public frmPet() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        petList = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtCodeDog = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNameDog = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtbornYearDog = new javax.swing.JTextField();
        txtColorDog = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        hsDog = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        breedDog = new javax.swing.JComboBox<>();
        chpedigree = new javax.swing.JCheckBox();
        createDog = new javax.swing.JButton();
        readDog = new javax.swing.JButton();
        updateDog = new javax.swing.JButton();
        delDog = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCodeCat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNameCat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtbornYearCat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtColorCat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        hsCat = new javax.swing.JComboBox<>();
        breedCat = new javax.swing.JComboBox<>();
        createCat = new javax.swing.JButton();
        readCat = new javax.swing.JButton();
        updateCat = new javax.swing.JButton();
        delCat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        petList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Pet1", "Pet2", "Pet3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(petList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addContainerGap())
        );

        Panel1.addTab("PetList", jPanel1);

        jLabel8.setText("Code");

        jLabel9.setText("Name");

        jLabel10.setText("Born year");

        jLabel11.setText("Color");

        jLabel12.setText("HealthStatus");

        hsDog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sick", "Healthy", "In Surgery" }));

        jLabel13.setText("Breed");

        breedDog.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Criollo", "Schnauzer", "German Shepherd", "Pincher" }));

        chpedigree.setText("Pedigree");

        createDog.setText("Create");
        createDog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDogActionPerformed(evt);
            }
        });

        readDog.setText("Read");
        readDog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readDogActionPerformed(evt);
            }
        });

        updateDog.setText("Update");
        updateDog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDogActionPerformed(evt);
            }
        });

        delDog.setText("Delete");
        delDog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delDogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hsDog, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(breedDog, 0, 248, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodeDog)
                            .addComponent(txtNameDog)
                            .addComponent(txtbornYearDog)
                            .addComponent(txtColorDog))))
                .addGap(111, 111, 111)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chpedigree)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(createDog)
                        .addComponent(readDog)
                        .addComponent(updateDog)
                        .addComponent(delDog)))
                .addGap(98, 98, 98))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCodeDog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chpedigree))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNameDog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtbornYearDog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(txtColorDog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(hsDog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(breedDog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(createDog)
                        .addGap(18, 18, 18)
                        .addComponent(readDog)
                        .addGap(18, 18, 18)
                        .addComponent(updateDog)
                        .addGap(18, 18, 18)
                        .addComponent(delDog)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        Panel1.addTab("Dog Manager", jPanel4);

        jLabel2.setText("Code");

        jLabel3.setText("Name");

        jLabel4.setText("Born year");

        jLabel5.setText("Color");

        jLabel6.setText("HealthStatus");

        jLabel7.setText("Breed");

        hsCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        breedCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        createCat.setText("Create");

        readCat.setText("Read");

        updateCat.setText("Update");

        delCat.setText("Delete");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNameCat)
                    .addComponent(txtCodeCat)
                    .addComponent(txtbornYearCat)
                    .addComponent(txtColorCat)
                    .addComponent(hsCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(breedCat, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createCat)
                    .addComponent(readCat)
                    .addComponent(updateCat)
                    .addComponent(delCat))
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodeCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNameCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createCat))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtbornYearCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(readCat))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtColorCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updateCat)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(hsCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delCat))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(breedCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        Panel1.addTab("Cat Manager", jPanel2);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setText("PetManager");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(253, 253, 253))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // BOTON DE CREATE - CREAR
    private void createDogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createDogActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(this, "Esto es una prueba");
        try {     //Try para encapsular errores en este caso por si ponen mal la fecha en el campo bornYear
            String code = txtCodeDog.getText();
            String name = txtNameDog.getText();
            String color = txtColorDog.getText();
            int bornYear = Integer.parseInt(txtbornYearDog.getText());
            String breed = breedDog.getSelectedItem().toString();
            String healthStatus = hsDog.getSelectedItem().toString();
            boolean pedigree = chpedigree.isSelected();
            
            //Condicional para no agregar el objeto perro nuevo hasta que los campos tengan info, las selecciones no porque ya tienen algo seleccionado
            if (code.equals("") || name.equals("") || color.equals("")){
                JOptionPane.showMessageDialog(this, "Fill all fields");
            }else{
                clsDog dog = new clsDog(breed,pedigree,code,name,bornYear,color,healthStatus);  //Crea el objeto perro
                ctlPet.CreatePet(dog);
                //dogObjectList.add(dog);    //Lo guarda en una lista
                this.FillJlist();    //Asigna la lista al despliegue GUI
                JOptionPane.showMessageDialog(this, "The record has been saved");
            }
            
        }catch (Exception e){   //Mensaje a desplegar de error
            JOptionPane.showMessageDialog(this, "Please add a valid born year");
        }
        
    }//GEN-LAST:event_createDogActionPerformed

        //BOTON DE BUSQUEDA   O READ
    private void readDogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readDogActionPerformed
        // TODO add your handling code here:
        String code = txtCodeDog.getText();   //Campo de busqueda
        clsDog dog = (clsDog) ctlPet.SearchPet(code, "Perro");  //Busqueda de un perro almacenado mandando su codigo y tipo
        
        /*boolean found = false;   //Variable de control para saber si encontro o no lo buscado
        
        for (clsDog dog : dogObjectList) {
            if (dog.getCode().equals(code)){
                txtNameDog.setText(dog.getName());
                txtColorDog.setText(dog.getColor());
                txtbornYearDog.setText(dog.getBorn_year()+"");
                hsDog.setSelectedItem(dog.getHealthStatus());
                breedDog.setSelectedItem(dog.getBreed());
                chpedigree.setSelected(dog.getPedigree());
                found = true;
                break;
            }
        }*/
        //Si la variable perro es nula, es porque no encontro nada y sale error de lo contrario muestra el contenido del objeto dog que se envio.
        if (dog == null){
            JOptionPane.showMessageDialog(this, "Code not found");
        }else{
            txtNameDog.setText(dog.getName());
            txtColorDog.setText(dog.getColor());
            txtbornYearDog.setText(dog.getBorn_year()+"");
            hsDog.setSelectedItem(dog.getHealthStatus());
            breedDog.setSelectedItem(dog.getBreed());
            chpedigree.setSelected(dog.getPedigree()); 
        }
        
    }//GEN-LAST:event_readDogActionPerformed

    private void updateDogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDogActionPerformed
        // TODO add your handling code here:
        String code = txtCodeDog.getText();   //Campo de busqueda
        boolean found = false;   //Variable de control para saber si encontro o no lo buscado
        
        //Se realiza busqueda pero en vez de mostrar se van a capturar los nuevos valores de las cajas de texto para modificar
        for (clsDog dog : dogObjectList) {
            if (dog.getCode().equals(code)){
                String name = txtNameDog.getText();
                String color = txtColorDog.getText();
                int bornYear = Integer.parseInt(txtbornYearDog.getText());
                String breed = breedDog.getSelectedItem().toString();
                String healthstatus = hsDog.getSelectedItem().toString();
                boolean pedigree = chpedigree.isSelected();
                dog.setName(name);     // Luego de capturar los datos en variables, se envian por set al objeto....
                dog.setColor(color);
                dog.setBorn_year(bornYear);
                dog.setHealthStatus(healthstatus);
                dog.setBreed(breed);
                dog.setPedigree(pedigree);
                this.clearDogFields();   //Borro campos de texto
                this.FillJlist();   //Actualizo la lista con su modelo de nuevo
                JOptionPane.showMessageDialog(this, "Record Updated");
                found = true;
                break;
            }
        }
        
        if (!found){
            JOptionPane.showMessageDialog(this, "Code not found");
        }
        
    }//GEN-LAST:event_updateDogActionPerformed

        //PARA BORRAR ELIMINAR REGISTRO
    private void delDogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delDogActionPerformed
        // TODO add your handling code here:
        String code = txtCodeDog.getText();   //Campo de busqueda
        boolean found = false;   //Variable de control para saber si encontro o no lo buscado
        
        //Se realiza busqueda pero en vez de mostrar se van a capturar los nuevos valores de las cajas de texto para modificar
        for (clsDog dog : dogObjectList) {
            if (dog.getCode().equals(code)){
                this.dogObjectList.remove(dog);  //El objeto encontrado dog, se elimina
                this.clearDogFields();   //Borro campos de texto
                this.FillJlist();   //Actualizo la lista con su modelo de nuevo
                JOptionPane.showMessageDialog(this, "Record Deleted");
                found = true;
                break;
            }
        }
        
        if (!found){
            JOptionPane.showMessageDialog(this, "Code not found");
        }
    }//GEN-LAST:event_delDogActionPerformed
    
    private void clearDogFields (){   //para limpiar los campos de texto cuando se busque, guarde o cualquier cosa
        txtCodeDog.setText("");
        txtNameDog.setText("");
        txtColorDog.setText("");
        txtbornYearDog.setText("");
        hsDog.setSelectedIndex(0);
        breedDog.setSelectedIndex(0);
        chpedigree.setSelected(false);
    }
    
    private void FillJlist(){
        DefaultListModel model = new DefaultListModel();
        int index =0;
        
        //Modelo de lista model.
        for (clsDog dog : dogObjectList){
            String data = dog.getName() + " - "+ dog.getBreed()+" - Perro";
            model.add(index, data);
            index++;
        }
        
        petList.setModel(model);   //La lista toma el modelo de lista model
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Panel1;
    private javax.swing.JComboBox<String> breedCat;
    private javax.swing.JComboBox<String> breedDog;
    private javax.swing.JCheckBox chpedigree;
    private javax.swing.JButton createCat;
    private javax.swing.JButton createDog;
    private javax.swing.JButton delCat;
    private javax.swing.JButton delDog;
    private javax.swing.JComboBox<String> hsCat;
    private javax.swing.JComboBox<String> hsDog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> petList;
    private javax.swing.JButton readCat;
    private javax.swing.JButton readDog;
    private javax.swing.JTextField txtCodeCat;
    private javax.swing.JTextField txtCodeDog;
    private javax.swing.JTextField txtColorCat;
    private javax.swing.JTextField txtColorDog;
    private javax.swing.JTextField txtNameCat;
    private javax.swing.JTextField txtNameDog;
    private javax.swing.JTextField txtbornYearCat;
    private javax.swing.JTextField txtbornYearDog;
    private javax.swing.JButton updateCat;
    private javax.swing.JButton updateDog;
    // End of variables declaration//GEN-END:variables
}
