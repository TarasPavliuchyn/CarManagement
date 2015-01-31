package com.carmanagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.carmanagement.car.Car;
import com.carmanagement.car.CarType;
import com.carmanagement.car.Engine;
import com.carmanagement.car.OilCar;

public class Runner {

	final static String P_UNIT = "HibernateMySQL";
	final static EntityManagerFactory EMF = Persistence
			.createEntityManagerFactory(P_UNIT);
	final static EntityManager EM = EMF.createEntityManager();

	public static void main(String[] args) {
		//
		// Query q = EM.createQuery("select c from Car c where c.id=13");
		// Car car = (Car) q.getSingleResult();
		// System.out.println(car);
//		Car car = new Car("Volkswagen", 190, CarType.MIDSIZE, 180.);
//		car.setTemp("dont persist");
//		car.setVersion(1);
//		car.setEngine(new Engine("GT", 500));
//		OilCar oilCar = new OilCar("Oilone", 500, CarType.LARGE, 200., 5);
//		oilCar.setEngine(new Engine("GT-2", 400));
		EntityTransaction transaction = EM.getTransaction();
		transaction.begin();
		// Car find = EM.find(Car.class, 1L);
//		 System.out.println(find);
		

		try {
//			EM.persist(car);
//			EM.persist(oilCar);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

		EM.close();
		EMF.close();
		System.out.println("DONE!!!");

	}

}
