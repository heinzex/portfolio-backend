package model;

import lombok.Data;

@Data
public class Response {

         private String result;
         
         public Response(String arg){
                   this.result = arg;
         }
}
