package co.com.david.arqullianLearn;

import javax.ejb.Stateless;

@Stateless
public class Saludo {

    public String saludar(){
        return "HOLA";
    }
}
