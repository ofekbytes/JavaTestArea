/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2012-2017 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package org.glassfish.json.jaxrs1x;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonStructure;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;

import javax.annotation.PostConstruct;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 * JAX-RS MessageBodyWriter for JsonStructure. This allows
 * JsonStructure, JsonArray and JsonObject to be return type of a
 * resource method.
 *
 * @author Jitendra Kotamraju
 * @author Blaise Doughan
 * @author Michal Gajdos
 */
@Provider
@Produces({"application/json", "text/json", "*/*"})
public class JsonStructureBodyWriter implements MessageBodyWriter<JsonStructure> {
    private static final String JSON = "json";
    private static final String PLUS_JSON = "+json";

    private JsonWriterFactory wf = Json.createWriterFactory(null);

    @PostConstruct
    private void init() {
        wf = Json.createWriterFactory(new HashMap<>());
    }

    @Override
    public boolean isWriteable(Class<?> aClass,
                               Type type, Annotation[] annotations, MediaType mediaType) {
        return JsonStructure.class.isAssignableFrom(aClass) && supportsMediaType(mediaType);
    }

    /**
     * @return true for all media types of the pattern *&#47;json and
     * *&#47;*+json.
     */
    private static boolean supportsMediaType(final MediaType mediaType) {
        return mediaType.getSubtype().equals(JSON) || mediaType.getSubtype().endsWith(PLUS_JSON);
    }

    @Override
    public long getSize(JsonStructure jsonStructure, Class<?> aClass,
                        Type type, Annotation[] annotations, MediaType mediaType) {

        return -1;
    }

    @Override
    public void writeTo(JsonStructure jsonStructure, Class<?> aClass, Type type,
                        Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> stringObjectMultivaluedMap,
                        OutputStream outputStream) throws IOException, WebApplicationException {
        try (JsonWriter writer = wf.createWriter(outputStream)) {
            writer.write(jsonStructure);
        }
    }
}
