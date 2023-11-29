/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbean;

import com.entities.ClientAccount;
import com.entities.Contac;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author nguye
 */
@Local
public interface ContacFacadeLocal {

    void create(Contac contac);

    void edit(Contac contac);

    void remove(Contac contac);

    Contac find(Object id);

    List<Contac> findAll();

    List<Contac> findRange(int[] range);

    int count();


    
}
