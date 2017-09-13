/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoweb.controllers;

/**
 *
 * @author 31206018
 */

import javax.servlet.http.HttpServletRequest;

public interface Controller {
    public void Execute();
    public void init(HttpServletRequest request);
    public String getReturnPage();
    
}
