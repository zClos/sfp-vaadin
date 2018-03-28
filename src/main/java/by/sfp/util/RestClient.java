//package by.sfp.util;
//
//import by.sfp.domain.DomainCategory;
//import by.sfp.mapping.ClassCategoryMapper;
//import by.sfp.mapping.DomainCategoryMapper;
//import org.glassfish.jersey.jackson.JacksonFeature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.GenericType;
//import javax.ws.rs.core.HttpHeaders;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.List;
//
//import static javax.ws.rs.client.Entity.json;
//
//@Component
//public class RestClient {
//    private String url = "http://178.124.206.49:8080/SFP/domainCategories";
//    private Client client;
//    private WebTarget webTarget;
//
//    @Autowired
//    private JsonConverter converter;
//
//    public RestClient() {
//        client = ClientBuilder.newClient();
//        webTarget = client.target(url)
//                .property(HttpHeaders.ACCEPT, "application/json;charset=utf8")
//                .property(HttpHeaders.CONTENT_TYPE, "application/json;charset=utf8")
//                .register(JacksonFeature.class);
//    }
//
//    public List<DomainCategory> getDomainCategories() {
//        return webTarget
//                .request()
//                .get()
//                .readEntity(new GenericType<List<DomainCategory>>() {});
//    }
//
//    public Response addClassCategory(Long domainCategoryId, ClassCategoryMapper classCategoryMapper) {
//        return webTarget
//                .path("/" + domainCategoryId + "/classCategories")
//                .request(MediaType.APPLICATION_JSON_TYPE)
//                .post(json(converter.toJson(classCategoryMapper)));
//    }
//
//    public Response saveDomainCategory(DomainCategoryMapper domainCategoryMapper) {
//        return webTarget
//                .request(MediaType.APPLICATION_JSON_TYPE)
//                .post(json(converter.toJson(domainCategoryMapper)));
//    }
//}
