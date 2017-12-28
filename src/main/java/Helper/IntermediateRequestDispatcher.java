package Helper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IntermediateRequestDispatcher {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String successMessage;
    private String failueMessage;
    private String destinationURL;

    public static class Builder {
        //Required
        private HttpServletRequest request;
        private HttpServletResponse response;
        private String destinationURL;

        //Optional
        private String successMessage = "";
        private String failueMessage = "";

        public Builder(HttpServletRequest request, HttpServletResponse response, String destinationURL) {
            this.request = request;
            this.response = response;
            this.destinationURL = destinationURL;
        }

        public Builder successMessage(String val) {
            this.successMessage = val;
            return this;
        }
        public Builder failueMessage(String val) {
            this.failueMessage = val;
            return this;
        }

        public IntermediateRequestDispatcher build() {
            return (new IntermediateRequestDispatcher(this));
        }
    }

    public void forward() throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
        rd.forward(request,response);
    }

    private IntermediateRequestDispatcher(Builder builder) {
        request = builder.request;
        response = builder.response;
        successMessage = builder.successMessage;
        failueMessage = builder.failueMessage;
        destinationURL = builder.destinationURL;
    }
}
