/**
 * Copyright © 2018 Sven Ruppert (sven.ruppert@gmail.com)
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
package org.rapidpm.vaadin.api.fluent.builder.api;

import static com.vaadin.flow.component.ComponentUtil.addListener;

import java.util.function.Consumer;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ClickNotifier;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.shared.Registration;

public interface ClickNotifierMixin<R extends ClickNotifierMixin, T extends ClickNotifier>
    extends NeutralMixin<R, T> {

  default R addClickListener(ComponentEventListener<ClickEvent<? extends Component>> listener ,
                             Consumer<Registration> registrationConsumer) {
    component()
        .map(component -> addListener((Component) component ,
                                      ClickEvent.class ,
                                      (ComponentEventListener) listener))
        .ifPresent(registrationConsumer);
    return (R) this;
  }

  default R addClickListener(ComponentEventListener<ClickEvent<? extends Component>> listener) {
    component()
        .map(component -> addListener((Component) component ,
                                      ClickEvent.class ,
                                      (ComponentEventListener) listener));
    return (R) this;
  }

}
