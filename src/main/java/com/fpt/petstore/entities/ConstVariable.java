package com.fpt.petstore.entities;


/**
 * contém constantes utilizadas em diversas partes da aplicação para facilitar a reutilização de valores fixos. Ela define redirecionamentos de URLs, quantidade de
 * produtos por página e as chaves de atributos de notificação, como título, mensagem e tema de
 * notificação (erro, aviso, sucesso), ajudando na padronização e manutenção do código.
 */


public class ConstVariable {
    public static final String redirect = "redirect:/";
    public static final int PRODUCTPERPAGE = 12;
 
   public static final String redirectRefer = "redirect:";
    public static final String titleNotification = "titleNotification";
    public static final String messageNotification = "messageNotification";
    //theme error,warning,success
    public static final String themeNotification = "themeNotification";

}
