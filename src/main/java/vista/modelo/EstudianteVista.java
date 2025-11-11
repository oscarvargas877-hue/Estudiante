/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.modelo;
// ============================================================================
// PARTE 1: IMPORTACIONES - NECESARIAS PARA USAR COLORES Y EVENTOS DE TECLADO
// ============================================================================

import javax.swing.text.*;        // Permite manipular texto con estilos (colores, negrita, etc)
import java.awt.Color;            // Para usar colores predefinidos (RED, BLUE, GREEN, etc)
import java.awt.event.KeyAdapter; // Permite detectar cuando el usuario presiona una tecla
import java.awt.event.KeyEvent;   // Contiene información del evento de teclado
/**
 *
 * @author Usuario
 */
// ============================================================================
// PARTE 2: ARRAY DE COLORES - DECLARADO DENTRO DE LA CLASE
// ============================================================================
public class EstudianteVista extends javax.swing.JFrame {
   // ARRAY QUE CONTIENE 9 COLORES DIFERENTES
    // Se utilizará para colorear cada letra del nombre de forma cíclica
    private Color[] colores = {
        Color.RED,                        // Color 0: Rojo
        Color.BLUE,                       // Color 1: Azul
        Color.GREEN,                      // Color 2: Verde
        Color.ORANGE,                     // Color 3: Naranja
        Color.MAGENTA,                    // Color 4: Magenta (Rosa fuerte)
        Color.CYAN,                       // Color 5: Cian (Azul claro)
        new Color(255, 0, 127),           // Color 6: Rosa personalizado (R=255, G=0, B=127)
        new Color(0, 255, 127),           // Color 7: Verde claro personalizado (R=0, G=255, B=127)
        new Color(127, 0, 255)            // Color 8: Púrpura personalizado (R=127, G=0, B=255)
    };
    /**
     * Creates new form Estudiantes
     */
    public EstudianteVista() {
        // initComponents() = Crea todos los componentes visuales (botones, campos de texto, etc)
        // Este método es generado automáticamente por NetBeans al diseñar la interfaz
        initComponents();
        
        // agregarListenerAlNombre() = Método personalizado que agrega un "escuchador"
        // Este escuchador detectará cuando el usuario escriba en el campo de nombre
        agregarListenerAlNombre();
       
    }
// ============================================================================
// PARTE 4: MÉTODO agregarListenerAlNombre() - PREPARA EL CAMPO PARA DETECTAR ESCRITURA
// ============================================================================

    private void agregarListenerAlNombre() {
        // txtNombre = El campo JTextPane donde el usuario ingresa el nombre
        
        // addKeyListener() = Agrega un "escuchador de eventos de teclado"
        // Cada vez que el usuario presiona o suelta una tecla, se ejecutará una acción
        txtNombre.addKeyListener(new KeyAdapter() {
            
            // @Override = Indica que estamos reemplazando un método de la clase padre (KeyAdapter)
            // keyReleased() = Evento que se dispara DESPUÉS de que el usuario suelta una tecla
            // (Se usa keyReleased en lugar de keyPressed porque es más estable)
            @Override
            public void keyReleased(KeyEvent e) {
                // Cada vez que se suelta una tecla, llamamos al método que aplica los colores
                aplicarColoresAlNombre();
            }
        });
    }
    
    // ============================================================================
// PARTE 5: MÉTODO aplicarColoresAlNombre() - APLICA COLORES A CADA LETRA
// ============================================================================

    private void aplicarColoresAlNombre() {
        
        // PASO 1: OBTENER EL TEXTO INGRESADO
        // getText() = Obtiene todo lo que el usuario escribió en txtNombre
        String texto = txtNombre.getText();
        
        // PASO 2: OBTENER EL DOCUMENTO CON ESTILOS
        // StyledDocument = Tipo de documento que permite aplicar estilos (colores, fuentes, etc)
        // getStyledDocument() = Obtiene el documento del JTextPane para poder modificarlo
        StyledDocument doc = txtNombre.getStyledDocument();
        
        
        // ========== LIMPIEZA DE ESTILOS ANTERIORES ==========
        
        // SimpleAttributeSet = Contenedor que guarda propiedades de formato (color, tamaño, negrita, etc)
        // new SimpleAttributeSet() = Crea un conjunto de atributos VACÍO (sin formato)
        SimpleAttributeSet atributoLimpio = new SimpleAttributeSet();
        
        // doc.setCharacterAttributes() = Aplica los atributos a caracteres específicos
        // Parámetros:
        //   - 0 = Posición inicial (desde el primer carácter)
        //   - doc.getLength() = Cantidad de caracteres (todos ellos)
        //   - atributoLimpio = Los atributos a aplicar (vacíos, es decir, sin formato)
        //   - true = Reemplaza cualquier formato anterior
        // RESULTADO: Se limpia todo el formato previo
        doc.setCharacterAttributes(0, doc.getLength(), atributoLimpio, true);
        
        
        // ========== APLICACIÓN DE COLORES A CADA LETRA ==========
        
        // for = Bucle que recorre cada letra del texto
        // int i = 0; i < texto.length(); i++
        //   - i = contador que empieza en 0
        //   - texto.length() = cantidad total de letras
        //   - i++ = incrementa i en 1 en cada vuelta
        for (int i = 0; i < texto.length(); i++) {
            
            // CREAR UN NUEVO CONJUNTO DE ATRIBUTOS PARA ESTA LETRA
            // Cada letra tendrá su propio conjunto de estilos
            SimpleAttributeSet atributo = new SimpleAttributeSet();
            
            // SELECCIONAR UN COLOR CÍCLICAMENTE
            // colores[i % colores.length]
            //   - i = posición de la letra (0, 1, 2, 3, etc)
            //   - % (módulo) = operador que da el residuo de una división
            //   - colores.length = cantidad de colores disponibles (9 colores)
            // EJEMPLO: Si tenemos 9 colores y i=0,1,2...8,9,10,11
            //          Los residuos serían:  0,1,2...8,0, 1, 2
            // RESULTADO: Se repiten los colores cíclicamente
            Color color = colores[i % colores.length];
            
            // ASIGNAR EL COLOR AL ATRIBUTO
            // StyleConstants.setForeground() = Establece el color del texto (color de frente)
            // Parámetros:
            //   - atributo = el conjunto de atributos que estamos modificando
            //   - color = el color seleccionado para esta letra
            StyleConstants.setForeground(atributo, color);
            
            // HACER EL TEXTO BOLD (NEGRITA)
            // StyleConstants.setBold() = Hace el texto más grueso/oscuro
            // Parámetros:
            //   - atributo = el conjunto de atributos que estamos modificando
            //   - true = activar la negrita
            StyleConstants.setBold(atributo, true);
            
            // APLICAR EL ATRIBUTO A LA LETRA ACTUAL
            // doc.setCharacterAttributes()
            // Parámetros:
            //   - i = posición de la letra (0 para la primera, 1 para la segunda, etc)
            //   - 1 = cantidad de caracteres a modificar (solo esta letra)
            //   - atributo = los atributos a aplicar (color y negrita)
            //   - false = no reemplaza otros atributos, solo agrega estos
            doc.setCharacterAttributes(i, 1, atributo, false);
        }
        // FIN DEL BUCLE - Se ha coloreado cada letra
    }
    
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        lblDatos = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblGenero = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblNombre.setText("Nombre");

        lblEdad.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblEdad.setText("Edad");

        lblCorreo.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblCorreo.setText("Correo");

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        lblDatos.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblDatos.setText("Datos Personales");

        jButton1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblGenero.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblGenero.setText("Género");

        lblId.setFont(new java.awt.Font("Cooper Black", 0, 14)); // NOI18N
        lblId.setText("Id Estudiante");

        txtId.setEditable(false);

        jScrollPane3.setViewportView(txtNombre);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(88, 88, 88)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblId)
                            .addComponent(lblEdad)
                            .addComponent(lblNombre)
                            .addComponent(lblCorreo)
                            .addComponent(lblGenero))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txtId)
                            .addComponent(txtGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))))
                .addContainerGap(472, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(330, 330, 330))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDatos)
                        .addGap(14, 14, 14)
                        .addComponent(lblNombre)
                        .addGap(24, 24, 24)
                        .addComponent(lblEdad)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCorreo)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGenero)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(196, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
             // Obtener texto del JTextPane con formato
             String nombre = txtNombre.getText();

             // Crear estudiante (usando texto plano para otros campos)
             Estudiante estudiantel = new Estudiante(
                 nombre,                   // primer parámetro: nombre
                 txtEdad.getText(),        // segundo parámetro: edad  
                 txtCorreo.getText(),      // tercer parámetro: correo
                 true                      // cuarto parámetro: genero
             );
            // Actualizar el campo de texto del ID con el ID del estudiante recién creado
            txtId.setText(String.valueOf(estudiantel.getId()));

          //IMPRIMIR EN PANTALLA
           txtResultado.setText(estudiantel.toString());
    
          
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(EstudianteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstudianteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstudianteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstudianteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstudianteVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDatos;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextPane txtNombre;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
