package bddweb.projet.controllers.communs;

public class BadRequestException extends Exception{

    private String message;

    //constructeur du BadRequest
    public BadRequestException (String message){
        super();
        this.message = message;
    }
}
