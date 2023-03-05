package reservation_consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import marriot_reservation_producer.MarriotInterface;
import marriot_reservation_producer.MarriotInterfaceImplementation;
import marriot_reservation_producer.Reservation;
import shangrilla_reservation_producer.ShangrillaInterface;
import shangrilla_reservation_producer.ShangrillaInterfaceImplementation;
import shangrilla_reservation_producer.ShangrillaReservation;


public class Activator implements BundleActivator {

	ServiceRegistration MarriotPublicServiceRegistration,ShangrillaPublicServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {

		MarriotInterface MarriotHotelConsumerService = new MarriotInterfaceImplementation();
		ShangrillaInterface ShangrillaHotelConsumerService = new ShangrillaInterfaceImplementation();

		MarriotPublicServiceRegistration = bundleContext.registerService(MarriotInterface.class.getName(), MarriotHotelConsumerService, null);
		ShangrillaPublicServiceRegistration = bundleContext.registerService(ShangrillaInterface.class.getName(), ShangrillaHotelConsumerService, null);

		System.out.println("Reservation Consumer Opened");


		Scanner scan =new Scanner(System.in);
		List<Reservation> roomBookings = new ArrayList<>();
		List<ShangrillaReservation> shangrillaroomBookings = new ArrayList<>();
		String roomName="" ,signal="y";
		int roomPrice=0,select=0,hotel=0;

		do {
			if(hotel==0) {
				System.out.println("******  Welcome to Hotel Reservation System  ******");
			}

			System.out.println("Select the hotel:\n"+"1) Marriot\n"+"2) Shangrilla\n"+"3) End the program");
			System.out.print("\nEnter the selection: ");
			hotel = Integer.parseInt(scan.nextLine());

			if(hotel==1) {
				System.out.println("******  Welcome to Marriot  ******");
				System.out.println("Select the number:\n"+"1) Start Booking\n"+"2) End the program");
				System.out.print("\nEnter the selection: ");
				select = Integer.parseInt(scan.nextLine());

				do {
				
					if(select==1) {
						if(!roomBookings.isEmpty()) {
							roomBookings.clear();
						}
						signal="y";
						System.out.print("\nBilling initialized\n\n");

						System.out.print("Enter your name: ");
						String bkname= scan.nextLine();

						System.out.print("Enter your NIC no: ");
						String bknic= scan.nextLine();

						System.out.print("Enter your Phone no: ");
						String bkphone= scan.nextLine();

						while(signal.equals("y")) {
							do {
								System.out.println("\nSelect the hall-");
								System.out.println("1) Banquet Hall - 50000");
								System.out.println("2) BallRoom - 80000");
								System.out.println("3) Conference Room - 90000\n");
								System.out.print("Enter the hall type: ");
								int bkroomtype= Integer.parseInt(scan.nextLine());

								if(bkroomtype==1) {
									roomName="Banquet Hall";
									roomPrice=50000;
									break;
								}
								else if(bkroomtype==2) {
									roomName="BallRoom";
									roomPrice=80000;
									break;
								}
								else if(bkroomtype==3) {
									roomName="Conference Room";
									roomPrice=90000;
									break;
								}
								else {
									System.out.println("Invalid input!!!");
								}
							}while(true);

							System.out.print("Enter the no of halls: ");
							int bknorooms= Integer.parseInt(scan.nextLine());

							System.out.print("Enter the no of days: ");
							int bknodays= Integer.parseInt(scan.nextLine());

							System.out.print("Enter meal type veg or non-veg: ");
							String bkmeals= scan.nextLine();

							Reservation booking = new Reservation(bkname, bknic, bkphone, roomName, roomPrice , bknorooms, bkmeals, bknodays);

							roomBookings.add(booking);

							System.out.print("Do you want to book more halls? If you want type 'y' else type 'n' : ");
							signal= scan.nextLine();

						}

						MarriotHotelConsumerService.printBill(roomBookings);
					}
					System.out.println("Select the number:\n"+"1) Start Booking\n"+"2) End the program");
					System.out.print("\nEnter the selection: ");
					select = Integer.parseInt(scan.nextLine());

				}while(select!=2);

			}
			else if(hotel==2) {
				System.out.println("**********  Welcome to Shangrilla  **********");

				do {
					System.out.println("Select the number:\n"+"1) Start Booking\n"+"2) End the program");
					System.out.print("\nEnter the selection: ");
					select = Integer.parseInt(scan.nextLine());

					if(select==1) {
						int discount=0;
						if(!shangrillaroomBookings.isEmpty()) {
							shangrillaroomBookings.clear();
						}
						signal="y";
						System.out.print("\nBilling initialized\n\n");

						System.out.print("Enter your name: ");
						String bkname= scan.nextLine();

						System.out.print("Enter your NIC no: ");
						String bknic= scan.nextLine();

						System.out.print("Enter your Phone no: ");
						String bkphone= scan.nextLine();

						while(signal.equals("y")) {
							do {
								System.out.println("\nSelect the hall-");
								System.out.println("1) Banquet Hall - 30000");
								System.out.println("2) BallRoom - 40000");
								System.out.println("3) Conference Room - 50000\n");
								System.out.print("Enter the hall type: ");
								int bkroomtype= Integer.parseInt(scan.nextLine());

								if(bkroomtype==1) {
									roomName="Banquet Hall";
									roomPrice=30000;
									break;
								}
								else if(bkroomtype==2) {
									roomName="BallRoom";
									roomPrice=40000;
									break;
								}
								else if(bkroomtype==3) {
									roomName="Conference Room";
									roomPrice=50000;
									break;
								}
								else {
									System.out.println("Invalid input!!!");
								}
							}while(true);

							System.out.print("Enter the no of halls: ");
							int bknorooms= Integer.parseInt(scan.nextLine());



							System.out.print("Enter the no of days: ");
							int bknodays= Integer.parseInt(scan.nextLine());

							System.out.print("Enter meal type veg or non-veg: ");
							String bkmeals= scan.nextLine();

							ShangrillaReservation booking = new ShangrillaReservation(bkname, bknic, bkphone, roomName, roomPrice , bknorooms, bkmeals, bknodays);

							shangrillaroomBookings.add(booking);

							if(bknorooms>1) {
								System.out.print("Do you want to book more halls? If you want type 'y' else type 'n' : ");
								signal= scan.nextLine();
							}
							else {
								break;
							}

						}

						ShangrillaHotelConsumerService.printBill(shangrillaroomBookings,discount);
					}

				}while(select!=2);

			}
			else {
				System.out.println("Invalid input\n");
			}

		}while(hotel!=3);





		scan.close();


	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Booking Consumer Closed");
		ShangrillaPublicServiceRegistration.unregister();
	}


}
