package br.com.concursos.view.managedbean;

import javax.inject.Named;

@Named
public class HelloBean
{
    public String getGreeting() 
    {
        return "Rodrigo";
    }
}
