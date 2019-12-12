package by.gsu.pms.task11.model;

public class Query {
    public static final String FIND_ALL_PARAMS_FOR_PRODUCT_GROUP_BY_NAME =
            "SELECT unit_of_measurement FROM param INNER JOIN params_in_groups as pig on param.id_param = pig.param_id WHERE pig.param_group_id = ?;";
    public static final String GET_PR_GROUP_ID_BY_NAME =
            "SELECT product_group.id_product_group FROM product_group WHERE product_group_name = ?;";
    public static final String GET_PARAM_ID_BY =
            "SELECT param.id_param FROM param where unit_of_measurement = ?;";
    public static final String GET_PARAM_GROUP_ID_BY_PARAM =
            "SELECT params_in_groups.param_group_id FROM params_in_groups INNER JOIN param on params_in_groups.param_id = param.id_param WHERE param.unit_of_measurement = ?;";
    public static final String GET_PRODUCT_WITHOUT_PARAM_GROUP =
            "SELECT * FROM product WHERE product_group_id = (SELECT product_group.id_product_group FROM product_group WHERE param_group_id NOT LIKE ?);";
    public static final String GET_PRODUCT_BY_PR_GROUP =
            "SELECT product.name, product.description, product.releaseDate FROM product INNER JOIN product_group pg on product.product_group_id = pg.id_product_group WHERE pg.product_group_name = ?;";
    public static final String GET_ALL_PRODUCTS =
            "SELECT product.name, product.description, product.releaseDate FROM product;";
    public static final String DELETE_PRODUCT_BY_PARAM =
            "DELETE FROM product WHERE product_group_id = (SELECT product_group.id_product_group FROM product_group WHERE param_group_id = ?);";
    public static final String GET_PARAM_GRP_ID_BY_NAME =
            "SELECT param_group.id_param_group FROM param_group WHERE param_group_name = ?;";
    public static final String UPDATE_PRODUCT_GROUPS_PARAM_GROUP_BY_NAME =
            "UPDATE product_group SET param_group_id = ? WHERE product_group_name = ?;";
}
