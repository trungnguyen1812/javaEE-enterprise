/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbean;

import com.entities.FeedBack;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author nguye
 */
@Local
public interface FeedBackFacadeLocal {

    void create(FeedBack feedBack);

    void edit(FeedBack feedBack);

    void remove(FeedBack feedBack);

    FeedBack find(Object id);

    List<FeedBack> findAll();

    List<FeedBack> findRange(int[] range);

    int count();
    
}
