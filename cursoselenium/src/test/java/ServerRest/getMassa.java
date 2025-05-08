package ServerRest;
import org.junit.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class getMassa {
        @Test
        public void testGetEndpoint() {
            RestAssured.config = RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
            RestAssured.baseURI = "https://randomuser.me";
    
            // Executa a requisição GET
            Response response = given()
                .header("Content-Type", "application/json")
            .when()
                .get("/api")
            .then()
                .statusCode(200) // Valida código de status
                .extract().response();
    
            // Obtém JSON da resposta
            String jsonBody = response.asString();
            System.out.println("Resposta JSON: " + jsonBody);
    
            // Executa a validação dinâmica do status code (como o eval do Postman)
            int statusCode = response.statusCode();
            validarStatusCode(statusCode);
    
            // Obtém informações do usuário da resposta
            String userName = response.path("results[0].name.first");
            String email = userName.toLowerCase() + "@gmail.com";
            String userPassword = response.path("results[0].login.password");
    
            System.out.println("Usuário: " + userName);
            System.out.println("Email: " + email);
            System.out.println("Senha: " + userPassword);
        }
    
        private void validarStatusCode(int statusCode) {
            switch (statusCode) {
                case 200:
                    System.out.println("Status OK: " + statusCode);
                    break;
                case 400:
                    System.out.println("Erro: Requisição inválida.");
                    break;
                default:
                    System.out.println("Código HTTP inesperado: " + statusCode);
            }
        }
}
