package com.a360vrsh.pansmartcitystory.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 驴妈妈商品详情bean
 */
public class TravelLMMGoodsDetailBean implements Serializable {
    @Override
    public String toString() {
        return "TravelLMMGoodsDetailBean{" +
                "data=" + data +
                ", errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    /**
     * data : {"id":182846,"goods_id":21169,"name":"万岁山大宋武侠城","image":["http://pic.lvmama.com//uploads/pc/place2/2016-09-07/be963734-9e1f-4a9c-a86a-d03df08be348.jpg","http://pic.lvmama.com//uploads/pc/place2/2016-09-07/44b9bf8d-6718-42a9-8922-db607490382d.jpg","http://pic.lvmama.com//uploads/pc/place2/2016-09-07/47df4796-e22c-4582-a277-ad371cbd744c.jpg","http://pic.lvmama.com//uploads/pc/place2/2016-09-07/2ae7f167-6561-4e49-bb6a-0c0716344a6d.jpg","http://pic.lvmama.com//uploads/pc/place2/2016-09-07/16399c75-0a82-4433-81f9-b9ec861711ce.jpg","http://pic.lvmama.com//uploads/pc/place2/2016-09-07/cf39ee6b-d699-47af-a6ed-8a9a51b81b76.jpg"],"price":"30.00","sales_total":7,"scenic_spot":{"level":"AAAA","address":"河南省开封市市区东京大道中段(近开封大学)","open_time":[{"sightStart":"08:00","sightEnd":"18:00"}],"lng":"114.3463035000","lat":"34.8196635600","description":"","image":""},"info":{"free_policy":"a. 1.2米（不含）以下的儿童免票。\nb. 70周岁（含）以上的老人（凭本人有效身份证或老年证）免票。\n* 如有其他消费项目，请按规定另行付费。","offer_crown":"a. 1.4米（含）～1.6米（不含）的儿童享景区优惠票。\nb. 60周岁（含）～70周岁（不含）的老人（凭本人有效身份证或老年证）享景区优惠票。\n* 如有其他消费项目，请按规定另行付费。","old_people":"","age":"","explanation":"","introdution":"万岁山大宋武侠城是由开封市万岁山游览区有限公司于2002年筹资兴建推出的主题园林项目，是一座以北宋文化、城墙文化和八朝文化为景观核心、以大宋武侠文化为旅游特色的多主题多景观大型游览区。","characteristic":["武侠豪情  神采飞扬","武林美景  博大精彩","万岁山春节大庙会","以森林自然为格调、兼具休闲娱乐功能的多主题、多景观大型游览区"],"play":[{"name":"大宋武侠城","description":"大宋武侠城以大宋武侠文化为核心旅游产品定位，致力于打造中国具魅力的武侠主题景区。常年推出精心编排的36部（每天60多场表演）实景武侠剧目，并逐步将主题剧目的进一步丰富，系统展现大宋武侠豪情与江湖百态。目前景区推出了以大型水浒实景马战《三打祝家庄》领衔的系列武侠实景剧演出，其中有《三打祝家庄》、《十字坡》《武松醉打蒋门神》《野猪林》为代表的水浒题材演出，集中再现了名著中众多绿林好汉的江湖豪情；","image":[]},{"name":"大宋武侠城","description":"以《七侠五义》《岳飞》为代表的侠义英雄题材演出，则展现了包拯、岳飞一文一武两位宋代忠臣、名将的侠肝义胆；以《桃花岛》、《四大名捕》为代表的金庸、古龙小说为题材的武侠演出带您感受武侠世界的浪漫情怀与恩怨情仇；《精武门》、《猛龙过江》近代武侠题材演出则凸显了李小龙、陈真等近代武侠人物的英雄形象。","image":[]},{"name":"大宋武侠城","description":"景区武侠文化的内涵，着力为游客打造体验式江湖生活，景区还特别推出了《武侠影视体验厅》、《武状元》和《李逵断案》为代表的互动剧目演出，让游客亲身参与到影视剧、武侠实景剧目的演出过程之中。具有宋代市井江湖风情的\u201c江湖情景街\u201d，集中再现了宋代市井江湖百态百业的文化风情：景观内的东京镖局、大宋赌坊、当铺、快活林酒家、科举书场等实景建筑林立、宋代道具文化氛围浓厚，不时有江湖大侠、官差衙役、镖师、媒婆、货郎、乞丐等还原宋代街景文化的江湖人物夹杂其间，现场与游客零距离接触，为游客打造了体验式江湖生活，置身其中，如...","image":[]},{"name":"大宋武侠城","description":"万岁山大宋武侠城作为开封一个以大宋武侠文化为旅游特色的主题景区，常年将宋文化作为景区发展主线，很重视宋武侠文化和景观氛围的塑造。位于景区中的《三打祝家庄》水浒马战宋式实景建筑群、再现宋代千年古刹辉煌的万岁寺、体现佛儒道精神的龙坛、目前世界上留存完整的明清古城墙遗址等众多景观形成了独特的江湖风情，而目前由景区筹建的中原人工山水景观瀑布群\u201c九龙瀑\u201d，则采用全新的设计理念，将宋文化与山水飞瀑作为描绘景观语言的主要元素，一抹飞阙将南北两条体现景区武侠文化与休闲文化主干道相连，形成宋文化、武侠文化相融合的景观...","image":[]},{"name":"大宋武侠城","description":"当您步入景区，行走在神器\u201c倚天剑\u201d、\u201c霸王刀\u201d巍巍伫立的武侠路上，感受《侠客行》景观中霸气凌人的气息、仰止于大宋武馆的\u201c侠客图\u201d之下，在十字坡\u201c剑坛\u201d中留下身影，尔后饮一盏清冽的\u201c大宋黄酒\u201d，醉卧于龙坛之下，侠客梦想、英雄情怀，尽在于此\u2026\u2026景区遍布各式表现武侠文化的建筑物以及四处飘扬的武侠门派旗帜，体现了景区浓郁的武侠文化氛围。","image":[]},{"name":"大宋武侠城","description":"万岁山大宋武侠城是开封旅游景区中拥有大面积森林资源的绿色生态景区，这里森林植被茂密、风景优美，得天独厚的自然景色，将地域广阔、森林植被花卉茂密、休闲设施齐全等众多优势集于一身，如今已成为中外游客来汴观光旅游的选之地。","image":[]},{"name":"大宋武侠城","description":"万岁山春节大庙会历经十余年发展，目前已成为中原地区阵容强、影响力的庙会，阵容庞大的演出规模、质美价优的特色小吃、琳琅满目的手工艺品、民俗特色的娱乐活动、红火喜庆的年味气氛以及区别于传统庙会的现代感融合了独特的武侠特色，都使之开封万岁山大庙会魅力无限、火爆非凡。作为每年春节期间开封旅游的龙头活动，景区庙会连续数十届的成功举办对开封旅游发展、大宋年文化节的打造、促进地区经济增长以及开封市创建国际化旅游名城都起到了推动作用。","image":[]},{"name":"大宋武侠城","description":"武林风云汇古今，数不尽英雄传奇。看刀光剑影临身孑然不惧，赏侠肝义胆心潮澎湃！圆武侠梦，过江湖瘾，尽在开封万岁山大宋武侠城！","image":[]}]},"store":{"id":14099,"title":"大乘旅行社-大相国寺","logo":"http://360vrsh.oss-cn-qingdao.aliyuncs.com/store_avatar/2020-04-13/E5g2tST0IQRalT6LOMfDpCCt1kPoKGI31SJ09vXL.jpeg","template":0,"is_verify":0},"ticket":[{"type":1,"type_name":"成人票","list":[{"id":25625492,"name":"成人票（提前2个小时预订）","is_change":1,"need_ticket":2,"price_min":"55.00","market_price_max":"60.00","info":{"other_rule":{"is_change":1,"deduction_type":2,"deduction_value":"100.0"},"cost_include":"景区成人门票1张。","cost_no_include":"","notice_visit_address":"","notice_get_ticket_time":"","notice_get_ticket_place":"","notice_way":"无需换票 扫短信二维码入园；* 该门票无需取票，可直接入园","notice_effective_desc":"指定游玩日1天内有效","notice_enter_limit_flag":1,"notice_enter_limit_time":null,"importent_point":"成人票（提前2个小时预订）的重要提示:预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。\n通关时间限制：下单后 02小时00分钟00秒 后可通关。","importent_notice":"","refund_rule_notice":"预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。"},"rule":[{"is_change":1,"ahead_time":-1380,"deduction_type":2,"deduction_value":"0.00"}],"pass_time":[{"name":"成人票（提前2个小时预订）","time":120}]},{"id":25625490,"name":"成人票","is_change":1,"need_ticket":2,"price_min":"60.00","market_price_max":"60.00","info":{"other_rule":{"is_change":1,"deduction_type":2,"deduction_value":"100.0"},"cost_include":"景区成人门票1张。","cost_no_include":"","notice_visit_address":"","notice_get_ticket_time":"","notice_get_ticket_place":"","notice_way":"无需换票 扫短信二维码入园；* 该门票无需取票，可直接入园","notice_effective_desc":"指定游玩日1天内有效","notice_enter_limit_flag":1,"notice_enter_limit_time":null,"importent_point":"成人票的重要提示:预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。\n","importent_notice":"","refund_rule_notice":"预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。"},"rule":[{"is_change":1,"ahead_time":-1380,"deduction_type":2,"deduction_value":"0.00"}],"pass_time":[]}]},{"type":5,"type_name":"活动票","list":[{"id":25625498,"name":"优待票","is_change":1,"need_ticket":2,"price_min":"30.00","market_price_max":"30.00","info":{"other_rule":{"is_change":1,"deduction_type":2,"deduction_value":"100.0"},"cost_include":"景区优待票1张。","cost_no_include":"","notice_visit_address":"","notice_get_ticket_time":"","notice_get_ticket_place":"","notice_way":"无需换票，凭本人有效证件扫短信二维码入园；* 该门票无需取票，可直接入园","notice_effective_desc":"指定游玩日1天内有效","notice_enter_limit_flag":1,"notice_enter_limit_time":null,"importent_point":"优待票的重要提示:预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。\n\n票种说明:优待票[1大0小]是指60周岁（含）～70周岁（不含）（老人）或1.2米（含）～1.4米（不含）（儿童）或年龄6周岁（含）-18周岁（不含）未成年/在读学生，凭学生证享受半价优惠","importent_notice":"","refund_rule_notice":"预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。"},"rule":[{"is_change":1,"ahead_time":-1380,"deduction_type":2,"deduction_value":"0.00"}],"pass_time":[]}]}],"is_favorites":0}
     * errcode : 0
     * errmsg : 成功
     */

    private DataBean data;
    private int errcode;
    private String errmsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public static class DataBean implements Serializable {
        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", goods_id=" + goods_id +
                    ", name='" + name + '\'' +
                    ", price='" + price + '\'' +
                    ", sales_total=" + sales_total +
                    ", scenic_spot=" + scenic_spot +
                    ", info=" + info +
                    ", store=" + store +
                    ", is_favorites=" + is_favorites +
                    ", image=" + image +
                    ", ticket=" + ticket +
                    '}';
        }

        /**
         * id : 182846
         * goods_id : 21169
         * name : 万岁山大宋武侠城
         * image : ["http://pic.lvmama.com//uploads/pc/place2/2016-09-07/be963734-9e1f-4a9c-a86a-d03df08be348.jpg","http://pic.lvmama.com//uploads/pc/place2/2016-09-07/44b9bf8d-6718-42a9-8922-db607490382d.jpg","http://pic.lvmama.com//uploads/pc/place2/2016-09-07/47df4796-e22c-4582-a277-ad371cbd744c.jpg","http://pic.lvmama.com//uploads/pc/place2/2016-09-07/2ae7f167-6561-4e49-bb6a-0c0716344a6d.jpg","http://pic.lvmama.com//uploads/pc/place2/2016-09-07/16399c75-0a82-4433-81f9-b9ec861711ce.jpg","http://pic.lvmama.com//uploads/pc/place2/2016-09-07/cf39ee6b-d699-47af-a6ed-8a9a51b81b76.jpg"]
         * price : 30.00
         * sales_total : 7
         * scenic_spot : {"level":"AAAA","address":"河南省开封市市区东京大道中段(近开封大学)","open_time":[{"sightStart":"08:00","sightEnd":"18:00"}],"lng":"114.3463035000","lat":"34.8196635600","description":"","image":""}
         * info : {"free_policy":"a. 1.2米（不含）以下的儿童免票。\nb. 70周岁（含）以上的老人（凭本人有效身份证或老年证）免票。\n* 如有其他消费项目，请按规定另行付费。","offer_crown":"a. 1.4米（含）～1.6米（不含）的儿童享景区优惠票。\nb. 60周岁（含）～70周岁（不含）的老人（凭本人有效身份证或老年证）享景区优惠票。\n* 如有其他消费项目，请按规定另行付费。","old_people":"","age":"","explanation":"","introdution":"万岁山大宋武侠城是由开封市万岁山游览区有限公司于2002年筹资兴建推出的主题园林项目，是一座以北宋文化、城墙文化和八朝文化为景观核心、以大宋武侠文化为旅游特色的多主题多景观大型游览区。","characteristic":["武侠豪情  神采飞扬","武林美景  博大精彩","万岁山春节大庙会","以森林自然为格调、兼具休闲娱乐功能的多主题、多景观大型游览区"],"play":[{"name":"大宋武侠城","description":"大宋武侠城以大宋武侠文化为核心旅游产品定位，致力于打造中国具魅力的武侠主题景区。常年推出精心编排的36部（每天60多场表演）实景武侠剧目，并逐步将主题剧目的进一步丰富，系统展现大宋武侠豪情与江湖百态。目前景区推出了以大型水浒实景马战《三打祝家庄》领衔的系列武侠实景剧演出，其中有《三打祝家庄》、《十字坡》《武松醉打蒋门神》《野猪林》为代表的水浒题材演出，集中再现了名著中众多绿林好汉的江湖豪情；","image":[]},{"name":"大宋武侠城","description":"以《七侠五义》《岳飞》为代表的侠义英雄题材演出，则展现了包拯、岳飞一文一武两位宋代忠臣、名将的侠肝义胆；以《桃花岛》、《四大名捕》为代表的金庸、古龙小说为题材的武侠演出带您感受武侠世界的浪漫情怀与恩怨情仇；《精武门》、《猛龙过江》近代武侠题材演出则凸显了李小龙、陈真等近代武侠人物的英雄形象。","image":[]},{"name":"大宋武侠城","description":"景区武侠文化的内涵，着力为游客打造体验式江湖生活，景区还特别推出了《武侠影视体验厅》、《武状元》和《李逵断案》为代表的互动剧目演出，让游客亲身参与到影视剧、武侠实景剧目的演出过程之中。具有宋代市井江湖风情的\u201c江湖情景街\u201d，集中再现了宋代市井江湖百态百业的文化风情：景观内的东京镖局、大宋赌坊、当铺、快活林酒家、科举书场等实景建筑林立、宋代道具文化氛围浓厚，不时有江湖大侠、官差衙役、镖师、媒婆、货郎、乞丐等还原宋代街景文化的江湖人物夹杂其间，现场与游客零距离接触，为游客打造了体验式江湖生活，置身其中，如...","image":[]},{"name":"大宋武侠城","description":"万岁山大宋武侠城作为开封一个以大宋武侠文化为旅游特色的主题景区，常年将宋文化作为景区发展主线，很重视宋武侠文化和景观氛围的塑造。位于景区中的《三打祝家庄》水浒马战宋式实景建筑群、再现宋代千年古刹辉煌的万岁寺、体现佛儒道精神的龙坛、目前世界上留存完整的明清古城墙遗址等众多景观形成了独特的江湖风情，而目前由景区筹建的中原人工山水景观瀑布群\u201c九龙瀑\u201d，则采用全新的设计理念，将宋文化与山水飞瀑作为描绘景观语言的主要元素，一抹飞阙将南北两条体现景区武侠文化与休闲文化主干道相连，形成宋文化、武侠文化相融合的景观...","image":[]},{"name":"大宋武侠城","description":"当您步入景区，行走在神器\u201c倚天剑\u201d、\u201c霸王刀\u201d巍巍伫立的武侠路上，感受《侠客行》景观中霸气凌人的气息、仰止于大宋武馆的\u201c侠客图\u201d之下，在十字坡\u201c剑坛\u201d中留下身影，尔后饮一盏清冽的\u201c大宋黄酒\u201d，醉卧于龙坛之下，侠客梦想、英雄情怀，尽在于此\u2026\u2026景区遍布各式表现武侠文化的建筑物以及四处飘扬的武侠门派旗帜，体现了景区浓郁的武侠文化氛围。","image":[]},{"name":"大宋武侠城","description":"万岁山大宋武侠城是开封旅游景区中拥有大面积森林资源的绿色生态景区，这里森林植被茂密、风景优美，得天独厚的自然景色，将地域广阔、森林植被花卉茂密、休闲设施齐全等众多优势集于一身，如今已成为中外游客来汴观光旅游的选之地。","image":[]},{"name":"大宋武侠城","description":"万岁山春节大庙会历经十余年发展，目前已成为中原地区阵容强、影响力的庙会，阵容庞大的演出规模、质美价优的特色小吃、琳琅满目的手工艺品、民俗特色的娱乐活动、红火喜庆的年味气氛以及区别于传统庙会的现代感融合了独特的武侠特色，都使之开封万岁山大庙会魅力无限、火爆非凡。作为每年春节期间开封旅游的龙头活动，景区庙会连续数十届的成功举办对开封旅游发展、大宋年文化节的打造、促进地区经济增长以及开封市创建国际化旅游名城都起到了推动作用。","image":[]},{"name":"大宋武侠城","description":"武林风云汇古今，数不尽英雄传奇。看刀光剑影临身孑然不惧，赏侠肝义胆心潮澎湃！圆武侠梦，过江湖瘾，尽在开封万岁山大宋武侠城！","image":[]}]}
         * store : {"id":14099,"title":"大乘旅行社-大相国寺","logo":"http://360vrsh.oss-cn-qingdao.aliyuncs.com/store_avatar/2020-04-13/E5g2tST0IQRalT6LOMfDpCCt1kPoKGI31SJ09vXL.jpeg","template":0,"is_verify":0}
         * ticket : [{"type":1,"type_name":"成人票","list":[{"id":25625492,"name":"成人票（提前2个小时预订）","is_change":1,"need_ticket":2,"price_min":"55.00","market_price_max":"60.00","info":{"other_rule":{"is_change":1,"deduction_type":2,"deduction_value":"100.0"},"cost_include":"景区成人门票1张。","cost_no_include":"","notice_visit_address":"","notice_get_ticket_time":"","notice_get_ticket_place":"","notice_way":"无需换票 扫短信二维码入园；* 该门票无需取票，可直接入园","notice_effective_desc":"指定游玩日1天内有效","notice_enter_limit_flag":1,"notice_enter_limit_time":null,"importent_point":"成人票（提前2个小时预订）的重要提示:预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。\n通关时间限制：下单后 02小时00分钟00秒 后可通关。","importent_notice":"","refund_rule_notice":"预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。"},"rule":[{"is_change":1,"ahead_time":-1380,"deduction_type":2,"deduction_value":"0.00"}],"pass_time":[{"name":"成人票（提前2个小时预订）","time":120}]},{"id":25625490,"name":"成人票","is_change":1,"need_ticket":2,"price_min":"60.00","market_price_max":"60.00","info":{"other_rule":{"is_change":1,"deduction_type":2,"deduction_value":"100.0"},"cost_include":"景区成人门票1张。","cost_no_include":"","notice_visit_address":"","notice_get_ticket_time":"","notice_get_ticket_place":"","notice_way":"无需换票 扫短信二维码入园；* 该门票无需取票，可直接入园","notice_effective_desc":"指定游玩日1天内有效","notice_enter_limit_flag":1,"notice_enter_limit_time":null,"importent_point":"成人票的重要提示:预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。\n","importent_notice":"","refund_rule_notice":"预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。"},"rule":[{"is_change":1,"ahead_time":-1380,"deduction_type":2,"deduction_value":"0.00"}],"pass_time":[]}]},{"type":5,"type_name":"活动票","list":[{"id":25625498,"name":"优待票","is_change":1,"need_ticket":2,"price_min":"30.00","market_price_max":"30.00","info":{"other_rule":{"is_change":1,"deduction_type":2,"deduction_value":"100.0"},"cost_include":"景区优待票1张。","cost_no_include":"","notice_visit_address":"","notice_get_ticket_time":"","notice_get_ticket_place":"","notice_way":"无需换票，凭本人有效证件扫短信二维码入园；* 该门票无需取票，可直接入园","notice_effective_desc":"指定游玩日1天内有效","notice_enter_limit_flag":1,"notice_enter_limit_time":null,"importent_point":"优待票的重要提示:预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。\n\n票种说明:优待票[1大0小]是指60周岁（含）～70周岁（不含）（老人）或1.2米（含）～1.4米（不含）（儿童）或年龄6周岁（含）-18周岁（不含）未成年/在读学生，凭学生证享受半价优惠","importent_notice":"","refund_rule_notice":"预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。"},"rule":[{"is_change":1,"ahead_time":-1380,"deduction_type":2,"deduction_value":"0.00"}],"pass_time":[]}]}]
         * is_favorites : 0
         */

        private int id;
        private int goods_id;
        private String name;
        private String price;
        private int sales_total;
        private ScenicSpotBean scenic_spot;
        private InfoBean info;
        private StoreBean store;
        private int is_favorites;
        private List<String> image;
        private List<TicketBean> ticket;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getSales_total() {
            return sales_total;
        }

        public void setSales_total(int sales_total) {
            this.sales_total = sales_total;
        }

        public ScenicSpotBean getScenic_spot() {
            return scenic_spot;
        }

        public void setScenic_spot(ScenicSpotBean scenic_spot) {
            this.scenic_spot = scenic_spot;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public StoreBean getStore() {
            return store;
        }

        public void setStore(StoreBean store) {
            this.store = store;
        }

        public int getIs_favorites() {
            return is_favorites;
        }

        public void setIs_favorites(int is_favorites) {
            this.is_favorites = is_favorites;
        }

        public List<String> getImage() {
            return image;
        }

        public void setImage(List<String> image) {
            this.image = image;
        }

        public List<TicketBean> getTicket() {
            return ticket;
        }

        public void setTicket(List<TicketBean> ticket) {
            this.ticket = ticket;
        }

        public static class ScenicSpotBean implements Serializable {
            /**
             * level : AAAA
             * address : 河南省开封市市区东京大道中段(近开封大学)
             * open_time : [{"sightStart":"08:00","sightEnd":"18:00"}]
             * lng : 114.3463035000
             * lat : 34.8196635600
             * description :
             * image :
             */

            private String level;
            private String address;
            private String lng;
            private String lat;
            private String description;
            private String image;
            private List<OpenTimeBean> open_time;

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public List<OpenTimeBean> getOpen_time() {
                return open_time;
            }

            public void setOpen_time(List<OpenTimeBean> open_time) {
                this.open_time = open_time;
            }

            public static class OpenTimeBean implements Serializable {
                /**
                 * sightStart : 08:00
                 * sightEnd : 18:00
                 */
                private String openTimeInfo;

                public String getOpenTimeInfo() {
                    return openTimeInfo;
                }

                public void setOpenTimeInfo(String openTimeInfo) {
                    this.openTimeInfo = openTimeInfo;
                }

                private String sightStart;
                private String sightEnd;

                public String getSightStart() {
                    return sightStart;
                }

                public void setSightStart(String sightStart) {
                    this.sightStart = sightStart;
                }

                public String getSightEnd() {
                    return sightEnd;
                }

                public void setSightEnd(String sightEnd) {
                    this.sightEnd = sightEnd;
                }
            }
        }

        public static class InfoBean implements Serializable {
            /**
             * free_policy : a. 1.2米（不含）以下的儿童免票。
             * b. 70周岁（含）以上的老人（凭本人有效身份证或老年证）免票。
             * 如有其他消费项目，请按规定另行付费。
             * offer_crown : a. 1.4米（含）～1.6米（不含）的儿童享景区优惠票。
             * b. 60周岁（含）～70周岁（不含）的老人（凭本人有效身份证或老年证）享景区优惠票。
             * 如有其他消费项目，请按规定另行付费。
             * old_people :
             * age :
             * explanation :
             * introdution : 万岁山大宋武侠城是由开封市万岁山游览区有限公司于2002年筹资兴建推出的主题园林项目，是一座以北宋文化、城墙文化和八朝文化为景观核心、以大宋武侠文化为旅游特色的多主题多景观大型游览区。
             * characteristic : ["武侠豪情  神采飞扬","武林美景  博大精彩","万岁山春节大庙会","以森林自然为格调、兼具休闲娱乐功能的多主题、多景观大型游览区"]
             * play : [{"name":"大宋武侠城","description":"大宋武侠城以大宋武侠文化为核心旅游产品定位，致力于打造中国具魅力的武侠主题景区。常年推出精心编排的36部（每天60多场表演）实景武侠剧目，并逐步将主题剧目的进一步丰富，系统展现大宋武侠豪情与江湖百态。目前景区推出了以大型水浒实景马战《三打祝家庄》领衔的系列武侠实景剧演出，其中有《三打祝家庄》、《十字坡》《武松醉打蒋门神》《野猪林》为代表的水浒题材演出，集中再现了名著中众多绿林好汉的江湖豪情；","image":[]},{"name":"大宋武侠城","description":"以《七侠五义》《岳飞》为代表的侠义英雄题材演出，则展现了包拯、岳飞一文一武两位宋代忠臣、名将的侠肝义胆；以《桃花岛》、《四大名捕》为代表的金庸、古龙小说为题材的武侠演出带您感受武侠世界的浪漫情怀与恩怨情仇；《精武门》、《猛龙过江》近代武侠题材演出则凸显了李小龙、陈真等近代武侠人物的英雄形象。","image":[]},{"name":"大宋武侠城","description":"景区武侠文化的内涵，着力为游客打造体验式江湖生活，景区还特别推出了《武侠影视体验厅》、《武状元》和《李逵断案》为代表的互动剧目演出，让游客亲身参与到影视剧、武侠实景剧目的演出过程之中。具有宋代市井江湖风情的\u201c江湖情景街\u201d，集中再现了宋代市井江湖百态百业的文化风情：景观内的东京镖局、大宋赌坊、当铺、快活林酒家、科举书场等实景建筑林立、宋代道具文化氛围浓厚，不时有江湖大侠、官差衙役、镖师、媒婆、货郎、乞丐等还原宋代街景文化的江湖人物夹杂其间，现场与游客零距离接触，为游客打造了体验式江湖生活，置身其中，如...","image":[]},{"name":"大宋武侠城","description":"万岁山大宋武侠城作为开封一个以大宋武侠文化为旅游特色的主题景区，常年将宋文化作为景区发展主线，很重视宋武侠文化和景观氛围的塑造。位于景区中的《三打祝家庄》水浒马战宋式实景建筑群、再现宋代千年古刹辉煌的万岁寺、体现佛儒道精神的龙坛、目前世界上留存完整的明清古城墙遗址等众多景观形成了独特的江湖风情，而目前由景区筹建的中原人工山水景观瀑布群\u201c九龙瀑\u201d，则采用全新的设计理念，将宋文化与山水飞瀑作为描绘景观语言的主要元素，一抹飞阙将南北两条体现景区武侠文化与休闲文化主干道相连，形成宋文化、武侠文化相融合的景观...","image":[]},{"name":"大宋武侠城","description":"当您步入景区，行走在神器\u201c倚天剑\u201d、\u201c霸王刀\u201d巍巍伫立的武侠路上，感受《侠客行》景观中霸气凌人的气息、仰止于大宋武馆的\u201c侠客图\u201d之下，在十字坡\u201c剑坛\u201d中留下身影，尔后饮一盏清冽的\u201c大宋黄酒\u201d，醉卧于龙坛之下，侠客梦想、英雄情怀，尽在于此\u2026\u2026景区遍布各式表现武侠文化的建筑物以及四处飘扬的武侠门派旗帜，体现了景区浓郁的武侠文化氛围。","image":[]},{"name":"大宋武侠城","description":"万岁山大宋武侠城是开封旅游景区中拥有大面积森林资源的绿色生态景区，这里森林植被茂密、风景优美，得天独厚的自然景色，将地域广阔、森林植被花卉茂密、休闲设施齐全等众多优势集于一身，如今已成为中外游客来汴观光旅游的选之地。","image":[]},{"name":"大宋武侠城","description":"万岁山春节大庙会历经十余年发展，目前已成为中原地区阵容强、影响力的庙会，阵容庞大的演出规模、质美价优的特色小吃、琳琅满目的手工艺品、民俗特色的娱乐活动、红火喜庆的年味气氛以及区别于传统庙会的现代感融合了独特的武侠特色，都使之开封万岁山大庙会魅力无限、火爆非凡。作为每年春节期间开封旅游的龙头活动，景区庙会连续数十届的成功举办对开封旅游发展、大宋年文化节的打造、促进地区经济增长以及开封市创建国际化旅游名城都起到了推动作用。","image":[]},{"name":"大宋武侠城","description":"武林风云汇古今，数不尽英雄传奇。看刀光剑影临身孑然不惧，赏侠肝义胆心潮澎湃！圆武侠梦，过江湖瘾，尽在开封万岁山大宋武侠城！","image":[]}]
             */

            private String free_policy;
            private String offer_crown;
            private String old_people;
            private String age;
            private String explanation;
            private String introdution;
            private List<String> characteristic;
            private List<PlayBean> play;

            public String getFree_policy() {
                return free_policy;
            }

            public void setFree_policy(String free_policy) {
                this.free_policy = free_policy;
            }

            public String getOffer_crown() {
                return offer_crown;
            }

            public void setOffer_crown(String offer_crown) {
                this.offer_crown = offer_crown;
            }

            public String getOld_people() {
                return old_people;
            }

            public void setOld_people(String old_people) {
                this.old_people = old_people;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getExplanation() {
                return explanation;
            }

            public void setExplanation(String explanation) {
                this.explanation = explanation;
            }

            public String getIntrodution() {
                return introdution;
            }

            public void setIntrodution(String introdution) {
                this.introdution = introdution;
            }

            public List<String> getCharacteristic() {
                return characteristic;
            }

            public void setCharacteristic(List<String> characteristic) {
                this.characteristic = characteristic;
            }

            public List<PlayBean> getPlay() {
                return play;
            }

            public void setPlay(List<PlayBean> play) {
                this.play = play;
            }

            public static class PlayBean implements Serializable {
                /**
                 * name : 大宋武侠城
                 * description : 大宋武侠城以大宋武侠文化为核心旅游产品定位，致力于打造中国具魅力的武侠主题景区。常年推出精心编排的36部（每天60多场表演）实景武侠剧目，并逐步将主题剧目的进一步丰富，系统展现大宋武侠豪情与江湖百态。目前景区推出了以大型水浒实景马战《三打祝家庄》领衔的系列武侠实景剧演出，其中有《三打祝家庄》、《十字坡》《武松醉打蒋门神》《野猪林》为代表的水浒题材演出，集中再现了名著中众多绿林好汉的江湖豪情；
                 * image : []
                 */

                private String name;
                private String description;
                private List<String> image;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public List<String> getImage() {
                    return image;
                }

                public void setImage(List<String> image) {
                    this.image = image;
                }
            }
        }

        public static class StoreBean implements Serializable {
            /**
             * id : 14099
             * title : 大乘旅行社-大相国寺
             * logo : http://360vrsh.oss-cn-qingdao.aliyuncs.com/store_avatar/2020-04-13/E5g2tST0IQRalT6LOMfDpCCt1kPoKGI31SJ09vXL.jpeg
             * template : 0
             * is_verify : 0
             */

            private int id;
            private String title;
            private String logo;
            private int template;
            private int is_verify;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public int getTemplate() {
                return template;
            }

            public void setTemplate(int template) {
                this.template = template;
            }

            public int getIs_verify() {
                return is_verify;
            }

            public void setIs_verify(int is_verify) {
                this.is_verify = is_verify;
            }
        }

        public static class TicketBean implements Serializable {
            /**
             * type : 1
             * type_name : 成人票
             * list : [{"id":25625492,"name":"成人票（提前2个小时预订）","is_change":1,"need_ticket":2,"price_min":"55.00","market_price_max":"60.00","info":{"other_rule":{"is_change":1,"deduction_type":2,"deduction_value":"100.0"},"cost_include":"景区成人门票1张。","cost_no_include":"","notice_visit_address":"","notice_get_ticket_time":"","notice_get_ticket_place":"","notice_way":"无需换票 扫短信二维码入园；* 该门票无需取票，可直接入园","notice_effective_desc":"指定游玩日1天内有效","notice_enter_limit_flag":1,"notice_enter_limit_time":null,"importent_point":"成人票（提前2个小时预订）的重要提示:预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。\n通关时间限制：下单后 02小时00分钟00秒 后可通关。","importent_notice":"","refund_rule_notice":"预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。"},"rule":[{"is_change":1,"ahead_time":-1380,"deduction_type":2,"deduction_value":"0.00"}],"pass_time":[{"name":"成人票（提前2个小时预订）","time":120}]},{"id":25625490,"name":"成人票","is_change":1,"need_ticket":2,"price_min":"60.00","market_price_max":"60.00","info":{"other_rule":{"is_change":1,"deduction_type":2,"deduction_value":"100.0"},"cost_include":"景区成人门票1张。","cost_no_include":"","notice_visit_address":"","notice_get_ticket_time":"","notice_get_ticket_place":"","notice_way":"无需换票 扫短信二维码入园；* 该门票无需取票，可直接入园","notice_effective_desc":"指定游玩日1天内有效","notice_enter_limit_flag":1,"notice_enter_limit_time":null,"importent_point":"成人票的重要提示:预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。\n","importent_notice":"","refund_rule_notice":"预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。"},"rule":[{"is_change":1,"ahead_time":-1380,"deduction_type":2,"deduction_value":"0.00"}],"pass_time":[]}]
             */

            private int type;
            private String type_name;
            private List<ListBean> list;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean implements Serializable {
                /**
                 * id : 25625492
                 * name : 成人票（提前2个小时预订）
                 * is_change : 1
                 * need_ticket : 2
                 * price_min : 55.00
                 * market_price_max : 60.00
                 * info : {"other_rule":{"is_change":1,"deduction_type":2,"deduction_value":"100.0"},"cost_include":"景区成人门票1张。","cost_no_include":"","notice_visit_address":"","notice_get_ticket_time":"","notice_get_ticket_place":"","notice_way":"无需换票 扫短信二维码入园；* 该门票无需取票，可直接入园","notice_effective_desc":"指定游玩日1天内有效","notice_enter_limit_flag":1,"notice_enter_limit_time":null,"importent_point":"成人票（提前2个小时预订）的重要提示:预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。\n通关时间限制：下单后 02小时00分钟00秒 后可通关。","importent_notice":"","refund_rule_notice":"预订付款后未使用，可在\u201c我的订单\u201d中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。"}
                 * rule : [{"is_change":1,"ahead_time":-1380,"deduction_type":2,"deduction_value":"0.00"}]
                 * pass_time : [{"name":"成人票（提前2个小时预订）","time":120}]
                 */

                private int id;
                private String name;
                private int is_change;
                private int need_ticket;
                private String price_min;
                private String market_price_max;
                private InfoBeanX info;
                private List<RuleBean> rule;
                private List<PassTimeBean> pass_time;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getIs_change() {
                    return is_change;
                }

                public void setIs_change(int is_change) {
                    this.is_change = is_change;
                }

                public int getNeed_ticket() {
                    return need_ticket;
                }

                public void setNeed_ticket(int need_ticket) {
                    this.need_ticket = need_ticket;
                }

                public String getPrice_min() {
                    return price_min;
                }

                public void setPrice_min(String price_min) {
                    this.price_min = price_min;
                }

                public String getMarket_price_max() {
                    return market_price_max;
                }

                public void setMarket_price_max(String market_price_max) {
                    this.market_price_max = market_price_max;
                }

                public InfoBeanX getInfo() {
                    return info;
                }

                public void setInfo(InfoBeanX info) {
                    this.info = info;
                }

                public List<RuleBean> getRule() {
                    return rule;
                }

                public void setRule(List<RuleBean> rule) {
                    this.rule = rule;
                }

                public List<PassTimeBean> getPass_time() {
                    return pass_time;
                }

                public void setPass_time(List<PassTimeBean> pass_time) {
                    this.pass_time = pass_time;
                }

                public static class InfoBeanX implements Serializable {
                    /**
                     * other_rule : {"is_change":1,"deduction_type":2,"deduction_value":"100.0"}
                     * cost_include : 景区成人门票1张。
                     * cost_no_include :
                     * notice_visit_address :
                     * notice_get_ticket_time :
                     * notice_get_ticket_place :
                     * notice_way : 无需换票 扫短信二维码入园；* 该门票无需取票，可直接入园
                     * notice_effective_desc : 指定游玩日1天内有效
                     * notice_enter_limit_flag : 1
                     * notice_enter_limit_time : null
                     * importent_point : 成人票（提前2个小时预订）的重要提示:预订付款后未使用，可在“我的订单”中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。
                     * 通关时间限制：下单后 02小时00分钟00秒 后可通关。
                     * importent_notice :
                     * refund_rule_notice : 预订付款后未使用，可在“我的订单”中申请退款，在游玩日当天23:00前申请，不收取任何手续费；逾期不可退改。
                     */

                    private OtherRuleBean other_rule;
                    private String cost_include;
                    private String cost_no_include;
                    private String notice_visit_address;
                    private String notice_get_ticket_time;
                    private String notice_get_ticket_place;
                    private String notice_way;
                    private String notice_effective_desc;
                    private String notice_enter_limit_flag;
                    private String notice_enter_limit_time;
                    private String importent_point;
                    private String importent_notice;
                    private String refund_rule_notice;

                    public OtherRuleBean getOther_rule() {
                        return other_rule;
                    }

                    public void setOther_rule(OtherRuleBean other_rule) {
                        this.other_rule = other_rule;
                    }

                    public String getCost_include() {
                        return cost_include;
                    }

                    public void setCost_include(String cost_include) {
                        this.cost_include = cost_include;
                    }

                    public String getCost_no_include() {
                        return cost_no_include;
                    }

                    public void setCost_no_include(String cost_no_include) {
                        this.cost_no_include = cost_no_include;
                    }

                    public String getNotice_visit_address() {
                        return notice_visit_address;
                    }

                    public void setNotice_visit_address(String notice_visit_address) {
                        this.notice_visit_address = notice_visit_address;
                    }

                    public String getNotice_get_ticket_time() {
                        return notice_get_ticket_time;
                    }

                    public void setNotice_get_ticket_time(String notice_get_ticket_time) {
                        this.notice_get_ticket_time = notice_get_ticket_time;
                    }

                    public String getNotice_get_ticket_place() {
                        return notice_get_ticket_place;
                    }

                    public void setNotice_get_ticket_place(String notice_get_ticket_place) {
                        this.notice_get_ticket_place = notice_get_ticket_place;
                    }

                    public String getNotice_way() {
                        return notice_way;
                    }

                    public void setNotice_way(String notice_way) {
                        this.notice_way = notice_way;
                    }

                    public String getNotice_effective_desc() {
                        return notice_effective_desc;
                    }

                    public void setNotice_effective_desc(String notice_effective_desc) {
                        this.notice_effective_desc = notice_effective_desc;
                    }

                    public String getNotice_enter_limit_flag() {
                        return notice_enter_limit_flag;
                    }

                    public void setNotice_enter_limit_flag(String notice_enter_limit_flag) {
                        this.notice_enter_limit_flag = notice_enter_limit_flag;
                    }

                    public String getNotice_enter_limit_time() {
                        return notice_enter_limit_time;
                    }

                    public void setNotice_enter_limit_time(String notice_enter_limit_time) {
                        this.notice_enter_limit_time = notice_enter_limit_time;
                    }

                    public String getImportent_point() {
                        return importent_point;
                    }

                    public void setImportent_point(String importent_point) {
                        this.importent_point = importent_point;
                    }

                    public String getImportent_notice() {
                        return importent_notice;
                    }

                    public void setImportent_notice(String importent_notice) {
                        this.importent_notice = importent_notice;
                    }

                    public String getRefund_rule_notice() {
                        return refund_rule_notice;
                    }

                    public void setRefund_rule_notice(String refund_rule_notice) {
                        this.refund_rule_notice = refund_rule_notice;
                    }

                    public static class OtherRuleBean implements Serializable {
                        /**
                         * is_change : 1
                         * deduction_type : 2
                         * deduction_value : 100.0
                         */

                        private int is_change;
                        private int deduction_type;
                        private String deduction_value;

                        public int getIs_change() {
                            return is_change;
                        }

                        public void setIs_change(int is_change) {
                            this.is_change = is_change;
                        }

                        public int getDeduction_type() {
                            return deduction_type;
                        }

                        public void setDeduction_type(int deduction_type) {
                            this.deduction_type = deduction_type;
                        }

                        public String getDeduction_value() {
                            return deduction_value;
                        }

                        public void setDeduction_value(String deduction_value) {
                            this.deduction_value = deduction_value;
                        }
                    }
                }

                public static class RuleBean implements Serializable {
                    /**
                     * is_change : 1
                     * ahead_time : -1380
                     * deduction_type : 2
                     * deduction_value : 0.00
                     */

                    private int is_change;
                    private int ahead_time;
                    private int deduction_type;
                    private String deduction_value;

                    public int getIs_change() {
                        return is_change;
                    }

                    public void setIs_change(int is_change) {
                        this.is_change = is_change;
                    }

                    public int getAhead_time() {
                        return ahead_time;
                    }

                    public void setAhead_time(int ahead_time) {
                        this.ahead_time = ahead_time;
                    }

                    public int getDeduction_type() {
                        return deduction_type;
                    }

                    public void setDeduction_type(int deduction_type) {
                        this.deduction_type = deduction_type;
                    }

                    public String getDeduction_value() {
                        return deduction_value;
                    }

                    public void setDeduction_value(String deduction_value) {
                        this.deduction_value = deduction_value;
                    }
                }

                public static class PassTimeBean implements Serializable {
                    /**
                     * name : 成人票（提前2个小时预订）
                     * time : 120
                     */

                    private String name;
                    private int time;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getTime() {
                        return time;
                    }

                    public void setTime(int time) {
                        this.time = time;
                    }
                }
            }
        }
    }
}
