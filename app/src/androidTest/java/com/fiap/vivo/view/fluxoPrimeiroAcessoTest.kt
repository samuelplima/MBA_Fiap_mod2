import android.view.ScrollCaptureTarget
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.fiap.vivo.R
import com.fiap.vivo.ui.activity.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class fluxoPrimeiroAcessoTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun primeiroAcessoOkTest() {
        Thread.sleep(1000)

        onView(withId(R.id.requireCpfCnpjField)).perform(
            replaceText("61306158095"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.searchLoginButton)).perform(click())
        Thread.sleep(1000)

        onView(withId(R.id.registrationNameField)).perform(replaceText("Iuri Magalhães Silva"))
        Thread.sleep(300)
        onView(withId(R.id.registrationEmailField)).perform(replaceText("iuri.magalhaes@gmail.com"))
        Thread.sleep(300)
        onView(withId(R.id.registrationPhoneField)).perform(replaceText("11954642716"))
        Thread.sleep(300)
        onView(withId(R.id.registrationPasswordField)).perform(scrollTo(), replaceText("teste"))
        Thread.sleep(300)

        onView(withId(R.id.registrationTypePhone)).perform(scrollTo(), click())

        onView(withId(R.id.registrationButtonSave)).perform(scrollTo(), click())
        Thread.sleep(1000)

        onView(withId(R.id.requireCpfCnpjLabel)).check(ViewAssertions.matches(isDisplayed()))
    }


    @Test
    fun primeiroAcessoNotOkTest() {
        Thread.sleep(1000)

        onView(withId(R.id.requireCpfCnpjField)).perform(
            replaceText("64559321027"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.searchLoginButton)).perform(click())
        Thread.sleep(500)

        onView(withId(R.id.registrationNameField)).perform(replaceText("Samuel Lima"))
        Thread.sleep(300)
        onView(withId(R.id.registrationEmailField)).perform(replaceText("samuel.lima.com"))
        Thread.sleep(300)
        onView(withId(R.id.registrationPhoneField)).perform(replaceText("11978952848"))
        Thread.sleep(300)
        onView(withId(R.id.registrationPasswordField)).perform(scrollTo(), replaceText("teste"))
        Thread.sleep(300)

        onView(withId(R.id.registrationTypeCombo)).perform(scrollTo(), click())

        onView(withId(R.id.registrationButtonSave)).perform(scrollTo(), click())
        Thread.sleep(1000)
        onView(withId(R.id.registrationPasswordField)).perform(scrollTo(),)

        onView(withId(R.id.registrationButtonSave)).check(ViewAssertions.matches(isDisplayed()))
    }

}
