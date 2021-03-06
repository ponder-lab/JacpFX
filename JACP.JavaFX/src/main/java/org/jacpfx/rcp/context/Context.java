/*
 * **********************************************************************
 *
 *  Copyright (C) 2010 - 2015
 *
 *  [Context.java]
 *  JACPFX Project (https://github.com/JacpFX/JacpFX/)
 *  All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an "AS IS"
 *  BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 *  express or implied. See the License for the specific language
 *  governing permissions and limitations under the License.
 *
 *
 * *********************************************************************
 */

package org.jacpfx.rcp.context;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import org.jacpfx.api.context.JacpContext;
import org.jacpfx.concurrency.FXWorker;
import org.jacpfx.rcp.componentLayout.FXComponentLayout;
import org.jacpfx.rcp.components.managedFragment.ManagedFragmentHandler;

/**
 * Created with IntelliJ IDEA.
 * User: ady
 * Date: 02.07.13
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public interface Context extends JacpContext<EventHandler<Event>, Object> {

    /**
     * Returns a managed fragment handler, which contains part of an UI and can fully interact with CDI and it's parent component.
     * @param clazz the class of the requested managed fragment
     * @param <T> the type of the managed fragment
     * @return a managedFragmentHandler which gives access to the fragments controller and UI node
     */
    <T> ManagedFragmentHandler<T> getManagedFragmentHandler(final Class<T> clazz);

    /**
     * shows the passed Node as modal dialog
     * @param node the Node to show in dialog
     */
    void showModalDialog(final Node node);

    /**
     * hides the current modal dialog
     */
    void hideModalDialog();

    /**
     * Retruns the component layout
     * @return The ComponentLayout handler
     */
    FXComponentLayout getComponentLayout();

    /**
     * The async handler allows to supply consumers, suppliers and function on worker thread and on FX thread
     * @return  an @see {AsyncHandler} instance
     */
     FXWorker<?> worker();
}
