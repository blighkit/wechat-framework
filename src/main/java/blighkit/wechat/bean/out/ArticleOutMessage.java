package blighkit.wechat.bean.out;


import blighkit.wechat.bean.in.InMessage;

import java.util.ArrayList;
import java.util.List;

public class ArticleOutMessage extends OutMessage {
    List<Article> articles = new ArrayList<Article>();

    public ArticleOutMessage(InMessage inMessage) {
        super(inMessage);
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>\n<ToUserName><![CDATA[");
        sb.append(getToUserName());
        sb.append("]]></ToUserName>\n<FromUserName><![CDATA[");
        sb.append(getFromUserName());
        sb.append("]]></FromUserName>\n<CreateTime>");
        sb.append(System.currentTimeMillis());
        sb.append("</CreateTime>\n<MsgType><![CDATA[news]]></MsgType\n><ArticleCount>");
        sb.append(getArticles().size());
        sb.append("</ArticleCount>\n<Articles>\n\t");
        for (Article article : getArticles()) {
            sb.append("<item>\n\t\t<Title><![CDATA[");
            sb.append(article.getTitle());
            sb.append("]]></Title>\n\t\t<Description><![CDATA[");
            sb.append(article.getDescription());
            sb.append("]]></Description>\n\t\t<PicUrl><![CDATA[");
            sb.append(article.getPicUrl()).append("]]></PicUrl>\n\t\t<Url><![CDATA[");
            sb.append(article.getUrl());
            sb.append("]]></Url>\n\t</item>\n");
        }
        sb.append("</Articles>\n</xml>");
        return sb.toString();
    }
}
