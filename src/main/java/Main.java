import com.maxleap.code.*;
import com.maxleap.code.impl.GlobalConfig;
import com.maxleap.code.impl.LoaderBase;
import com.maxleap.code.impl.MLResponse;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by johnny on 16/1/18.
 */

public class Main extends LoaderBase implements Loader{

    Logger logger = LoggerFactory.getLogger(Main.class);

    public void main(GlobalConfig globalConfig) {
        AtomicInteger count = new AtomicInteger();

        //定义Cloud Function
        defineFunction("pay", new MLHandler<Request, Response<String>>() {
            @Override
            public Response<String> handle(Request request) {
                count.incrementAndGet();
                String params = request.parameter(String.class);
                logger.info(count.hashCode() + "-->" + count.get());
                Response<String> response = new MLResponse<String>(String.class);
                response.setResult("hello" + params);
                response.putHeader("content-type", "text/plain");
                return response;
            }
        });

        //定义Cloud Job
        defineJob("payJob", new MLHandler<Request, Response<String>>() {


            @Override
            public Response<String> handle(Request request) {
                return null;
            }
        });
    }
}
