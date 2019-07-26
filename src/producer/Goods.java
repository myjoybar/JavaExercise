package producer;

/**
 * Created by joybar on 2019/1/15.
 */
public class Goods {
    public final String name;
    public final int price;
    public final int id;

    public Goods(String name, int price, int id){
        this.name = name; /*类型*/
        this.price = price; /*价格*/
        this.id = id; /*商品序列号*/
    }

    @Override
    public String toString(){
        return "name: " + name + ",   price:"+ price + ",   id: " + id;
    }
}