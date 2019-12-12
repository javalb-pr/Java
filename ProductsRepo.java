package by.gsu.pms.task11.repo;

import by.gsu.pms.task11.model.Database;
import by.gsu.pms.task11.model.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsRepo {
    @Autowired
    private Database database;

    public int getProductGroupsIdByName(String name) {
        int result = -1;
        try {
            PreparedStatement preparedStatement = database.getConnection().prepareStatement(Query.GET_PR_GROUP_ID_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> getProductGroupParamsById(int productGroupId){
        List<String> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = database.getConnection().prepareStatement(Query.FIND_ALL_PARAMS_FOR_PRODUCT_GROUP_BY_NAME);
            preparedStatement.setInt(1, productGroupId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getParamGroupIdByParam(String param){
        int result = -1;
        try {
            PreparedStatement preparedStatement = database.getConnection().prepareStatement(Query.GET_PARAM_GROUP_ID_BY_PARAM);
            preparedStatement.setString(1, param);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getProductWithoutParamGroupById(int id){
        StringBuilder result = new StringBuilder("");
        try {
            PreparedStatement preparedStatement = database.getConnection().prepareStatement(Query.GET_PRODUCT_WITHOUT_PARAM_GROUP);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result.append(resultSet.getString("name"));
                result.append(" ").append(resultSet.getString("description"));
                result.append(" ").append(resultSet.getString("releaseDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public List<String> getProductByPrGroup(String group){
        List<String> result = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = database.getConnection().prepareStatement(Query.GET_PRODUCT_BY_PR_GROUP);
            preparedStatement.setString(1, group);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String resultProduct = "" + resultSet.getString("name") +
                        " " + resultSet.getString("description") +
                        " " + resultSet.getString("releaseDate");
                result.add(resultProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> getAllProducts(){
        List<String> result = new ArrayList<>();
        try {
            ResultSet resultSet = database.getConnection().prepareStatement(Query.GET_ALL_PRODUCTS).executeQuery();
            while (resultSet.next()){
                String resultProduct = "" + resultSet.getString("name") +
                        " " + resultSet.getString("description") +
                        " " + resultSet.getString("releaseDate");
                result.add(resultProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void deleteProductByParamId(int paramId){
        try {
            PreparedStatement preparedStatement = database.getConnection().prepareStatement(Query.DELETE_PRODUCT_BY_PARAM);
            preparedStatement.setInt(1, paramId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getParamGroupIdByName(String name){
        int result = -1;
        try {
            PreparedStatement preparedStatement = database.getConnection().prepareStatement(Query.GET_PARAM_GRP_ID_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void transferParamGroupToProductGroup(int paramGroupId, String productGroupName){
        try {
            PreparedStatement preparedStatement = database.getConnection().prepareStatement(Query.UPDATE_PRODUCT_GROUPS_PARAM_GROUP_BY_NAME);
            preparedStatement.setInt(1, paramGroupId);
            preparedStatement.setString(2, productGroupName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
