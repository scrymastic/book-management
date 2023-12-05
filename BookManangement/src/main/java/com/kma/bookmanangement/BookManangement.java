/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kma.bookmanangement;

import com.kma.bookmanangement.ui.ListBookForm;
import com.kma.bookmanangement.ui.WelcomeForm;

/**
 *
 * @author lxsgo
 */
public class BookManangement {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeForm().setVisible(true);
            }
        });
    }
}
