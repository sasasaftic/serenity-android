/**
 * The MIT License (MIT)
 * Copyright (c) 2012 David Carver
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF
 * OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package us.nineworlds.serenity.core.services.test;

import static org.junit.Assert.*;
import static org.junit.Assume.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import us.nineworlds.serenity.GDMReceiver;
import us.nineworlds.serenity.MainActivity;
import us.nineworlds.serenity.SerenityApplication;
import us.nineworlds.serenity.core.services.GDMService;

/**
 * @author dcarver
 *
 */
@RunWith(RobolectricTestRunner.class)
@Config(reportSdk=14, emulateSdk=17)
public class GDMServiceTest {

	
	private BroadcastReceiver gdmReciver = new GDMReceiver();
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		IntentFilter filters = new IntentFilter();
		filters.addAction(GDMService.MSG_RECEIVED);
		filters.addAction(GDMService.SOCKET_CLOSED);
		LocalBroadcastManager.getInstance(Robolectric.buildActivity(MainActivity.class).create().get()).registerReceiver(gdmReciver,
				filters);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link us.nineworlds.serenity.core.services.GDMService#onHandleIntent(android.content.Intent)}.
	 */
	@Test
	@Ignore
	public void testOnHandleIntentIntent() throws Exception {
		
		MockGDMService service = new MockGDMService();
		Intent intent = new Intent();
		service.onHandleIntent(intent);
		
		Thread.sleep(2500);
		assumeTrue(SerenityApplication.getPlexMediaServers().size() > 0);
	}
	
	public class MockGDMService extends GDMService {
		
		@Override
		public void onHandleIntent(Intent intent) {
			super.onHandleIntent(intent);
		}
		
	}

}
