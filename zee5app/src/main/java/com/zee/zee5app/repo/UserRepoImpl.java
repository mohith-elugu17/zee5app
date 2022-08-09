package com.zee.zee5app.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;
import com.zee.zee5app.utils.DBUtils;

public class UserRepoImpl implements UserRepo {
	
	private HashSet<User> users = new HashSet<>();
	private static UserRepo userRepo;

	public static UserRepo getInstance() {
		if (userRepo == null)
			userRepo = new UserRepoImpl();
		return userRepo;
	}
	
	private DBUtils dbUtils = DBUtils.getInstance();

    @Override
    public User insertUser(User user) throws UnableToGenerateIdException {
        // TODO Auto-generated method stub

        Connection connection = null;        
        PreparedStatement preparedStatement = null;
        String insertStatement = "insert into user_table" 
                + "(userid, firstname, lastname, email, doj, dob, active)"
                + "values(?,?,?,?,?,?,?)";

        connection = dbUtils.getConnection();

        try {
            preparedStatement = connection.prepareStatement(insertStatement);
            preparedStatement.setString(1, DBUtils.getInstance().userIdGenerator(user.getFirstName(), user.getLastName()));
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setDate(5, Date.valueOf(user.getDoj()));
            preparedStatement.setDate(6, Date.valueOf(user.getDob()));
            preparedStatement.setBoolean(7, user.isActive());

            int result = preparedStatement.executeUpdate();

            if(result > 0) {
                return user;
            }
            else {
                return null;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            dbUtils.closeConnection(connection);
        }
        return null;
    }

//	private List<User> users = new LinkedList<>();

//	@Override
//	public User insertUser(User user) {
//		// TODO Auto-generated method stub
//		boolean result = users.add(user);
//		if (result)
//			return user;
//		return null;
//	}

	@Override
	public Optional<User> updateUserById(String userId, User user) throws InvalidIdException, UnableToGenerateIdException {
		// TODO Auto-generated method stub
		Connection connection = null;      
        PreparedStatement preparedStatement = null;
        String updateStatement = "update user_table" +
                " set userid=?, firstname=?, lastname=?, email=?, doj=?, dob=?, active=?" +
                " where userid=?";
        connection = dbUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(updateStatement);
            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setDate(5, Date.valueOf(user.getDoj()));
            preparedStatement.setDate(6, Date.valueOf(user.getDob()));
            preparedStatement.setBoolean(7, user.isActive());

            preparedStatement.setString(8, userId);

            int result = preparedStatement.executeUpdate();

            if(result > 0) {
                return Optional.of(user);
            }
            else {
                throw new InvalidIdException("userid is not present");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            dbUtils.closeConnection(connection);
        }
        return Optional.empty();
	}

	@Override
	public String deleteUserById(String userId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		String query  = "delete from user_table where userid=?";
		Connection connection = null;        
        PreparedStatement preparedStatement = null;
        
        connection = dbUtils.getConnection();
        try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
	        int result = preparedStatement.executeUpdate();
	        if(result > 0) {
	        	return "success";
	        }
	        else {
	        	throw new NoDataFoundException("userId is not Present");
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return "Fail";
	}

	@Override
	public Optional<List<User>> getAllUsers() {
		// TODO Auto-generated method stub
		Connection connection = null;        
        PreparedStatement preparedStatement = null;
        String query = "select * from user_table";
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        connection = dbUtils.getConnection();
        try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getString("userid"));
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastname"));
				user.setEmail(resultSet.getString("email"));
				user.setDoj(resultSet.getDate("doj").toLocalDate());
				user.setDob(resultSet.getDate("dob").toLocalDate());
				user.setActive(resultSet.getBoolean("active"));
				users.add(user);
			}
			return Optional.of(users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
        return Optional.empty();
		
	}

	@Override
	public Optional<User> getUserById(String userId) {
		// TODO Auto-generated method stub
		Connection connection = null;        
        PreparedStatement preparedStatement = null;
        String query = "select * from user_table where userid=?";
        ResultSet resultSet = null;
        
        connection = dbUtils.getConnection();
        try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				User user = new User();
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastname"));
				user.setEmail(resultSet.getString("email"));
				user.setDoj(resultSet.getDate("doj").toLocalDate());
				user.setDob(resultSet.getDate("dob").toLocalDate());
				user.setActive(resultSet.getBoolean("active"));
				return Optional.of(user);
			}
			else {
				return Optional.empty();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
        return Optional.empty();
	}
}

