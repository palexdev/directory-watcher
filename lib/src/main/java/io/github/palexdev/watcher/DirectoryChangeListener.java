/*
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
package io.github.palexdev.watcher;

import java.io.IOException;

/**
 * A listener that is called when file change events occur or when exceptions occur while watching.
 */
@FunctionalInterface
public interface DirectoryChangeListener {

  static DirectoryChangeListener of(DirectoryChangeListener... listeners) {
    return new DirectoryChangeListener() {
      @Override
      public void onEvent(DirectoryChangeEvent event) throws IOException {
        for (DirectoryChangeListener listener : listeners) {
          listener.onEvent(event);
        }
      }

      @Override
      public void onException(Exception e) {
        for (DirectoryChangeListener listener : listeners) {
          listener.onException(e);
        }
      }

      @Override
      public void onIdle(int count) {
        for (DirectoryChangeListener listener : listeners) {
          listener.onIdle(count);
        }
      }

      @Override
      public boolean isWatching() {
        boolean anyWatching = false;
        for (DirectoryChangeListener listener : listeners) {
          anyWatching |= listener.isWatching();
        }
        return anyWatching;
      }
    };
  }

  void onEvent(DirectoryChangeEvent event) throws IOException;

  /** The watcher will stop watching after this method returns false. */
  default boolean isWatching() {
    return true;
  }

  default void onIdle(int count) {
    // ignore onIdle by default
  }

  /**
   * A handler for uncaught exceptions. Throwing an exception from here will terminate the watcher.
   */
  default void onException(Exception e) {
    // Ignore exceptions by default (they will be logged by the watcher)
  }
}
