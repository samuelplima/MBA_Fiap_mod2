import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.fiap.vivo.R
import com.fiap.vivo.view.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class fluxoCnpjTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun cnpjUsuarioInvalidoTest() {
        Thread.sleep(1000)

        onView(withId(R.id.requireCpfCnpjField)).perform(
            replaceText("32.473.878/0001-31"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.searchLoginButton)).perform(click())
        Thread.sleep(500)
        onView(withId(R.id.docCheck)).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun buscarEmpresaComCnpjCadastradoTest() {
        Thread.sleep(1000)

        onView(withId(R.id.requireCpfCnpjField)).perform(
            replaceText("44.444.444/4444-44"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.searchLoginButton)).perform(click())
        Thread.sleep(500)
        onView(withId(R.id.loginPageTitle)).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun buscarEmpresaComCnpjVazioTest() {
        Thread.sleep(1000)

        onView(withId(R.id.requireCpfCnpjField)).perform(
            replaceText(""),
            closeSoftKeyboard()
        )
        onView(withId(R.id.searchLoginButton)).perform(click())
        Thread.sleep(500)
        onView(withId(R.id.docCheck)).check(ViewAssertions.matches(isDisplayed()))
    }

}
