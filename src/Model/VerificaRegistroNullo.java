package Model;

import javax.swing.*;

import static View.View.chamaMenuPrincipal;

public class VerificaRegistroNullo {
    public static void verificaRegistroNullo(Object obj) {
        if (obj == null || obj.toString().isEmpty()) {
       JOptionPane.showMessageDialog(null, "O campo não pode ser vazio!");
            chamaMenuPrincipal();
        }
    }
}
