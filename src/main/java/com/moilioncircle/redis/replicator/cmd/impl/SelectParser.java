/*
 * Copyright 2016 leon chen
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

package com.moilioncircle.redis.replicator.cmd.impl;

import com.moilioncircle.redis.replicator.cmd.Command;
import com.moilioncircle.redis.replicator.cmd.CommandName;
import com.moilioncircle.redis.replicator.cmd.CommandParser;

/**
 * Created by leon on 8/13/16.
 */
public class SelectParser implements CommandParser<SelectParser.SelectCommand> {
    @Override
    public SelectCommand parse(CommandName cmdName, Object[] params) {
        int index = Integer.parseInt((String) params[0]);
        return new SelectCommand(index);
    }

    public static class SelectCommand implements Command {
        private final int index;

        public int getIndex() {
            return index;
        }

        public SelectCommand(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "SelectCommand{" +
                    "index='" + index + '\'' +
                    '}';
        }

        @Override
        public CommandName name() {
            return CommandName.name("SELECT");
        }
    }
}
