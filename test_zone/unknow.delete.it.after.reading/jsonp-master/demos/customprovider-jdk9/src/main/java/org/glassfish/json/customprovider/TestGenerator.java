/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2017 Oracle and/or its affiliates. All rights reserved.
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

package org.glassfish.json.customprovider;

import javax.json.JsonException;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Jitendra Kotamraju
 */
public class TestGenerator implements JsonGenerator {
    private final Writer writer;

    public TestGenerator(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void flush() {
    }

    @Override
    public JsonGenerator writeStartObject() {
        return null;
    }

    @Override
    public JsonGenerator writeStartObject(String name) {
        return null;
    }

    @Override
    public JsonGenerator write(String name, String fieldValue) {
        return null;
    }

    @Override
    public JsonGenerator write(String name, int value) {
        return null;
    }

    @Override
    public JsonGenerator write(String name, long value) {
        return null;
    }

    @Override
    public JsonGenerator write(String name, double value) {
        return null;
    }

    @Override
    public JsonGenerator write(String name, BigInteger value) {
        return null;
    }

    @Override
    public JsonGenerator write(String name, BigDecimal value) {
        return null;
    }

    @Override
    public JsonGenerator write(String name, boolean value) {
        return null;
    }

    @Override
    public JsonGenerator writeNull(String name) {
        return null;
    }

    @Override
    public JsonGenerator write(JsonValue value) {
        return null;
    }

    @Override
    public JsonGenerator writeStartArray() {
        try {
            writer.write("[");
        } catch(IOException ioe) {
            throw new JsonException("I/O error", ioe);
        }
        return this;
    }

    @Override
    public JsonGenerator writeStartArray(String name) {
        return null;
    }

    @Override
    public JsonGenerator write(String name, JsonValue value) {
        return null;
    }

    @Override
    public JsonGenerator write(String value) {
        return null;
    }


    @Override
    public JsonGenerator write(int value) {
        return null;
    }

    @Override
    public JsonGenerator write(long value) {
        return null;
    }

    @Override
    public JsonGenerator write(double value) {
        return null;
    }

    @Override
    public JsonGenerator write(BigInteger value) {
        return null;
    }

    @Override
    public JsonGenerator write(BigDecimal value) {
        return null;
    }

    @Override
    public JsonGenerator write(boolean value) {
        return null;
    }

    @Override
    public JsonGenerator writeNull() {
        return null;
    }

    @Override
    public JsonGenerator writeEnd() {
        try {
            writer.write("]");
        } catch(IOException ioe) {
            throw new JsonException("I/O error", ioe);
        }
        return this;
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch(IOException ioe) {
            throw new JsonException("I/O error", ioe);
        }
    }

    @Override
    public JsonGenerator writeKey(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
