package tests_unitaires;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import service.CalculatriceService;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("A special test case")
class CalculatriceServiceTest
{
	@Test
	@DisplayName("╯°□°）╯")
    @Tag("Maths")
	@Order(3)
	void testAdditionEntier()
	{
		int a = 2, b = 5;

		int result = CalculatriceService.additionner(a, b);

		assertEquals(result, 7);
	}

	@Test
    @Tag("JUnit")
	@Order(2)
	void testInAllEnvironments()
	{
		System.out.println(System.getenv("JAVA_HOME"));
		assumingThat("CI".equals(System.getenv("ENV")), () ->
		{
			// perform these assertions only on the CI server
			assertEquals(2, CalculatriceService.diviser(4, 2));
		});

		// perform these assertions in all environments
		assertEquals(42, CalculatriceService.multiplier(6, 7));
	}

	@Test
	@Disabled("Désactivé !")
	@Order(4)
	void testWillBeSkipped()
	{
	}

	@Test
	@EnabledOnOs({ OS.WINDOWS })
	@Order(1)
	void onWindows()
	{
		System.out.println("Test exécuté sur Windows uniquement !");
	}

	@Test
	@DisabledOnOs(OS.WINDOWS)
	@Order(5)
	void notOnWindows()
	{
		System.out.println("Test exécuté hors Windows uniquement !");
	}

	@Test
	@EnabledOnOs({ OS.LINUX, OS.MAC })
	@Order(6)
	void onLinuxOrMac()
	{
		System.out.println("Test exécuté sur Linux et Mac uniquement !");
	}
}