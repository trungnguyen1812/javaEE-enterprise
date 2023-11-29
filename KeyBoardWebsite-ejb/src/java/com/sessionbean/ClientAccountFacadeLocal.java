/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbean;

import com.entities.ClientAccount;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author nguye
 */
@Local
public interface ClientAccountFacadeLocal {

    void create(ClientAccount clientAccount);

    void edit(ClientAccount clientAccount);

    void remove(ClientAccount clientAccount);

    ClientAccount find(Object id);

    List<ClientAccount> findAll();

    List<ClientAccount> findRange(int[] range);

    int count();

    public ClientAccount findClientAccountByEmail(String accountEmail);
    
}
