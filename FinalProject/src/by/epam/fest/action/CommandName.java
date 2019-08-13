package by.epam.fest.action;

public enum CommandName {
    ERROR(""),
    LANGUAGE("change_Lang"),
    FEST_TABLE("festival_table"),
    SIGN_IN("sign_in"),
    SIGN_OUT("sign_out"),
    REGISTRATION("registration"),
    //user
    BOOK_TICKET("book_ticket"),
    DELETE_USAGE("delete_usage"),
    TICKETS("1111"),
    TICKET_TABLE("2222"),
    //musician
    ADD_SONG("add_song"),
    DELETE_SONG("delete_song"),
    UPLOAD_IMG("upload_file"),
    //admin
    ADD_DAY("add_day"),
    ADD_MUSICIAN("add_musician"),
    DELETE_MUSICIAN("delete_musician"),
    DELETE_USER("delete_user"),
    PAGE_FEST("3333"),
    MUSICIAN_TABLE("musician_table"),
    USER_TABLE("user_table"),
    UPDATE_PRICES("update_price");

    private String name;

    private CommandName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
   public static CommandName findEnum(String name){
        CommandName commandName=null;
       CommandName[] values = CommandName.values();
       String enumValue = null;
       for(CommandName eachValue : values) {
           if(eachValue.getName().equals(name)){
               return eachValue;
           }
       }
       return commandName;
   }
}
