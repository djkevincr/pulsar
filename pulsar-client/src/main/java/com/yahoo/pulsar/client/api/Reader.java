/**
 * Copyright 2016 Yahoo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yahoo.pulsar.client.api;

import java.io.Closeable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * A Reader can be used to scan through all the messages currently available in a topic.
 *
 */
public interface Reader extends Closeable {

    /**
     * @return the topic from which this reader is reading from
     */
    String getTopic();

    /**
     * Read the next message in the topic
     *
     * @return the next messasge
     * @throws PulsarClientException
     */
    Message readNext() throws PulsarClientException;

    /**
     * Read the next message in the topic.
     *
     * @return the next messasge
     * @throws PulsarClientException
     */
    Message readNext(int timeout, TimeUnit unit) throws PulsarClientException;

    CompletableFuture<Message> readNextAsync();

    /**
     * Asynchronously close the reader and stop the broker to push more messages
     *
     * @return a future that can be used to track the completion of the operation
     */
    CompletableFuture<Void> closeAsync();

    /**
     * Return true if the topic was terminated and this reader has reached the end of the topic
     */
    boolean hasReachedEndOfTopic();
}
