package band.wukong.mz.g.sku.service;

import band.wukong.mz.g.sku.bean.Sku;
import band.wukong.mz.g.sku.bean.SkuMore;
import org.nutz.dao.QueryResult;

import java.util.List;

/**
 * As you see...
 *
 * @author wukong(wukonggg@139.com)
 */
public interface SkuService {

    /**
     * 保存Sku以及SkuMore。先保存图片文件到文件系统，再进数据库。
     *
     * @param s    pojo without id
     * @param path 图片文件存放路径
     */
    void saveWithMore(Sku s, String path);

    /**
     * 找某个保存Sku，包括more,goods
     *
     * @param id id
     * @return
     */
    Sku findWithLinks(Long id);

    /**
     * update db and file system
     *
     * @param sc
     * @param moreList
     * @param path     图片文件存放路径
     */
    void updateWithMore(Sku sc, List<SkuMore> moreList, String path);

    /**
     * remove in db
     *
     * @param id id
     */
    void rm(Long id);

    /**
     * 查询
     *
     * @param cateCode cateCode
     * @param qcond    qcond
     * @param pageNum  page number
     * @param pageSize page size
     * @return QueryResult 包含GoodsList和Page
     */
    QueryResult list(String cateCode, String qcond, int pageNum, int pageSize);

    /**
     * 出货。减少库存数量
     *
     * @param skuMoreId skuMoreId
     * @param count     需要减少的库存量
     * @return 返回剩余库存量
     */
    int reduceStock(long skuMoreId, int count);

    /**
     * 增加库存量
     *
     * @param skuMoreId skuMoreId
     * @param count     需要增加的库存量
     * @return 返回当前总库存量
     */
    int addStock(long skuMoreId, int count);
}
