package com.carmanagement.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.carmanagement.car.Car;
import com.carmanagement.car.CarType;

public class JDBCDao {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/jpa";
	static final String DB_USER = "root";
	static final String DB_PASSWORD = "root";

	public static void create(Car car) {
		Connection conn = getConnection();
		String sql = "INSERT INTO Cars (model, car_power, maxSpeed, carType, CAR_TYPE) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, car.getModel());
			statement.setString(2, car.getPower().toString());
			statement.setString(3, car.getMaxSpeed().toString());
			statement.setString(4, car.getCarType().toString());
			statement.setString(5, "N");
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new car was inserted successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(Long id) {
		Connection conn = getConnection();
		String sql = "DELETE FROM Cars WHERE id=?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id.toString());
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A car was deleted successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Car select(Long id) {
		Car car = new Car();
		Connection conn = getConnection();
		String sql = "SELECT id, model, car_power, carType FROM Cars WHERE id=? ";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, id.toString());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				car.setId(Long.parseLong(result.getString(1)));
				car.setModel(result.getString(2));
				car.setPower(result.getInt(3));
				car.setCarType(CarType.valueOf(result.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}

	private static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("Connected");
		return conn;
	}
	public static void updateModel(String model, Long id) {
		Connection conn = getConnection();
		String sql = "UPDATE  Cars SET model = ? WHERE id = ?";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, model);
			statement.setString(2, id.toString());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A car was updeted successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Car car = new Car("KIA", 20, CarType.MIDSIZE, 190.);
		// String cartype = car.getCarType().toString();
		// System.out.println(cartype);
		// JDBCDao.create(car);
		//JDBCDao.delete(6L);
		//Car car = JDBCDao.select(5L);
		//System.out.println(car);
		JDBCDao.updateModel("test", 5L);
	}
}
