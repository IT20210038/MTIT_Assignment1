package marriot_reservation_producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration publicServiceRegistration;

	public void start(BundleContext context) throws Exception {
		
		MarriotInterface hotelService = new MarriotInterfaceImplementation();
		publicServiceRegistration = context.registerService(MarriotInterface.class.getName(), hotelService, null);
		
		System.out.println("Marriot Producer Opened");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Marriot Producer Closed");
		publicServiceRegistration.unregister();
	}

}
