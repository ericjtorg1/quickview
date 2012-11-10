/**
 *
 Copyright 2012 Vineet Semwal

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.aplombee.navigator;

import com.aplombee.RepeaterUtil;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Vineet Semwal
 *
 */
public class AjaxComponentScrollEventBehaviorTest {
    @Test(groups = {"wicketTests"})
    public void  getPrecondition(){
        WebMarkupContainer parent=new WebMarkupContainer("parent");
        parent.setMarkupId("parent");
         AjaxComponentScrollEventBehavior behavior=new AjaxComponentScrollEventBehavior() {
             @Override
             protected void onScroll(AjaxRequestTarget target) {
             };
         };
        parent.add(behavior);
        String actual=behavior.getPreconditionScript().toString();
        String expected="return "+ RepeaterUtil.get().isComponentScrollBarAtBottom(parent)+";";
        Assert.assertEquals(actual, expected);

    }

}