/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package org.apache.logging.log4j.core.layout;

import java.nio.ByteBuffer;

/**
 * ByteBufferDestination addresses the problem a producer has when the destination ByteBuffer is not large enough to
 * fit all the data. This interface allows a producer to write arbitrary amounts of data to a destination.
 *
 * @since 2.6
 */
public interface ByteBufferDestination {
    /**
     * Returns the buffer to write to.
     *
     * @return the buffer to write to
     */
    ByteBuffer getByteBuffer();

    /**
     * Consumes the buffer content and returns a buffer with more {@linkplain ByteBuffer#remaining() available} space
     * (which may or may not be the same instance).
     * <p>
     * Called by the producer when buffer becomes too full to write to.
     *
     * @param buf the buffer to drain
     * @return a buffer with more available space (which may or may not be the same instance)
     */
    ByteBuffer drain(ByteBuffer buf);

    /**
     * Returns the number of bytes that have been written to this destination.
     *
     * @return the number of bytes that have been {@link #drain(ByteBuffer) drained} plus the number of bytes that are
     *          still in the buffer.
     */
    long size();
}
