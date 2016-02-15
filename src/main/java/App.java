import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/parcel", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      int height = Integer.parseInt(request.queryParams("height"));
      int width = Integer.parseInt(request.queryParams("width"));
      int length = Integer.parseInt(request.queryParams("length"));
      int weight = Integer.parseInt(request.queryParams("weight"));
      int distance = Integer.parseInt(request.queryParams("distance"));
      String speed = request.queryParams("speed");
      String giftwrap = request.queryParams("giftwrap");

      Parcel myParcel = new Parcel(height, width, length, weight);
      String cost = myParcel.getShipCost(distance, speed, giftwrap);
      model.put("cost", cost);

      model.put("template", "templates/parcel.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }


}
