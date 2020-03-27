
import javax.swing.JOptionPane;


public class Seguridad {
    frmLogin login=new frmLogin();
   String strRespuesta;
   /**
     * Hace la validación entre el usuario que se ingresa manualmente con respecto a los que están dentro del archivo.
     * Requiere cuatro parámetros: Usuario[], strUsuario, strContraseña, int Intentos.
     */
    public void ValidarUsuarios(String Usuario[],String strUsuario, String strContraseña, int Intentos){
        boolean blEncontrado=false;
      
        for(int i=0; i < Usuario.length;i++){  
        if ((Usuario[i].equalsIgnoreCase(strUsuario)&& Usuario[i+1].equals(strContraseña))){
             strRespuesta="Bienvenido "+strUsuario;
             blEncontrado=true;
             JOptionPane.showMessageDialog(null, strRespuesta, "Inicio de sesión", JOptionPane.INFORMATION_MESSAGE);
             Intentos=0;
             login.setIntentos(Intentos);
             new mdiMenuPrincipal().setVisible(true);
                  break;
        
            }
        }if (blEncontrado==false){
            strRespuesta= "Usuraio o contraseña no válidos van: "+ Intentos+ " intentos fallidos.";
               JOptionPane.showMessageDialog(null, strRespuesta, "Inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
         if(Intentos> 2){
            JOptionPane.showMessageDialog(null, "3 intentros fallidos.", "Inicio de sesión", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            }   
    }
    
}
