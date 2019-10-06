# 본사에서 제품을 관리 

## product function (url, description, authority)
- product/list(get), 허용 상품 리스트, all
- product/list(post), 전체 상품 리스트, admin
- product/list(put), 상품 업데이트, admin
- product/list(delete), 상품 비활성화, admin  

## product table
- tb_product 
  - product_id (pk)
  - code_id
  - product_name
  - enabled
  - description

## code table
- tb_code 
  - code_id (pk)
  - code_name
  - enabled
  - description 
  
  
## setup 
<code>
# docker run -d -p 3000:3306 -v wp-db-vol:/docker/mysql/mas02db -e MYSQL_ROOT_PASSWORD=password --name mas02db mysql:5.7 --character-set-server=utf8 --collation-server=utf8_unicode_ci  
# docker exec -it mas02db bash
# mysql -u root -p
# create schema mas02db;
# create user 'user01'@'%' identified by 'user01';
# grant all privileges on mas02db.* to 'user01'@'%';
# commit;
</code>