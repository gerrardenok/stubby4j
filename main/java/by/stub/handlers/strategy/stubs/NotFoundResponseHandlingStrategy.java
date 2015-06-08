/*
HTTP stub server written in Java with embedded Jetty

Copyright (C) 2012 Alexander Zagniotov, Isa Goksu and Eric Mrak

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package by.stub.handlers.strategy.stubs;

import by.stub.yaml.stubs.StubRequest;
import org.eclipse.jetty.http.HttpStatus;
import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;

public final class NotFoundResponseHandlingStrategy implements StubResponseHandlingStrategy {

   public NotFoundResponseHandlingStrategy() {}

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public void handle(final HttpServletResponse response, final StubRequest assertionStubRequest) throws Exception {
      JSONObject jResponse = new JSONObject();
      jResponse.put("query", new JSONObject(assertionStubRequest.getQuery()));
      jResponse.put("headers", new JSONObject(assertionStubRequest.getHeaders()));
      jResponse.put("body", assertionStubRequest.getPostBody());

      response.setHeader("Content-Type", "application/json");
      response.getWriter().print(jResponse.toString());
      response.setStatus(HttpStatus.NOT_FOUND_404);
   }

}
