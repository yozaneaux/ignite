/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.visor.snapshot;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.ignite.internal.dto.IgniteDataTransferObject;
import org.apache.ignite.internal.util.typedef.internal.S;
import org.apache.ignite.internal.util.typedef.internal.U;

/**
 * Argument for the task to create snapshot.
 */
public class VisorSnapshotCreateTaskArg extends IgniteDataTransferObject {
    /** Serial version uid. */
    private static final long serialVersionUID = 0L;

    /** Snapshot name. */
    private String snpName;

    /** Synchronous execution flag. */
    private boolean sync;

    /** Default constructor. */
    public VisorSnapshotCreateTaskArg() {
        // No-op.
    }

    /**
     * @param snpName Snapshot name.
     * @param sync Synchronous execution flag.
     */
    public VisorSnapshotCreateTaskArg(String snpName, boolean sync) {
        this.snpName = snpName;
        this.sync = sync;
    }

    /** @return Snapshot name. */
    public String snapshotName() {
        return snpName;
    }

    /** @return Synchronous execution flag. */
    public boolean sync() {
        return sync;
    }

    /** {@inheritDoc} */
    @Override protected void writeExternalData(ObjectOutput out) throws IOException {
        U.writeString(out, snpName);
        out.writeBoolean(sync);
    }

    /** {@inheritDoc} */
    @Override protected void readExternalData(byte ver, ObjectInput in) throws IOException, ClassNotFoundException {
        snpName = U.readString(in);
        sync = in.readBoolean();
    }

    /** {@inheritDoc} */
    @Override public String toString() {
        return S.toString(VisorSnapshotCreateTaskArg.class, this);
    }
}
