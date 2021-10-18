This code is for reproduce `lateinit property relocationRequesterNode has not been initialized` problem.

```
Exception in thread "AWT-EventQueue-0" kotlin.UninitializedPropertyAccessException: lateinit property relocationRequesterNode has not been initialized
	at androidx.compose.ui.layout.RelocationRequesterModifier.getRelocationRequesterNode(RelocationRequesterModifier.kt:32)
	at androidx.compose.ui.layout.RelocationRequester.bringIntoView(RelocationRequester.kt:61)
	at androidx.compose.ui.layout.RelocationRequester.bringIntoView$default(RelocationRequester.kt:59)
	at androidx.compose.foundation.FocusableKt$focusable$2$4$1.invokeSuspend(Focusable.kt:108)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:106)
	at androidx.compose.ui.platform.FlushCoroutineDispatcher$dispatch$2.invokeSuspend(CoroutineDispatchers.desktop.kt:55)
	at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
	at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:106)
	at java.desktop/java.awt.event.InvocationEvent.dispatch(InvocationEvent.java:316)
	at java.desktop/java.awt.EventQueue.dispatchEventImpl(EventQueue.java:770)
	at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:721)
	at java.desktop/java.awt.EventQueue$4.run(EventQueue.java:715)
	at java.base/java.security.AccessController.doPrivileged(AccessController.java:391)
	at java.base/java.security.ProtectionDomain$JavaSecurityAccessImpl.doIntersectionPrivilege(ProtectionDomain.java:85)
	at java.desktop/java.awt.EventQueue.dispatchEvent(EventQueue.java:740)
	at java.desktop/java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:203)
	at java.desktop/java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:124)
	at java.desktop/java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:113)
	at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:109)
	at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
	at java.desktop/java.awt.EventDispatchThread.run(EventDispatchThread.java:90)

```

Test scenario:
1. Click `Details 1` and click on text field
2. Click `Welcome`
3. Click `Details 2` and click on text field
4. Click `Details 3` and click on text field (crash!)