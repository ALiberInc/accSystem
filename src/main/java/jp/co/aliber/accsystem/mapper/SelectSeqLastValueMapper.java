package jp.co.aliber.accsystem.mapper;

/**
 * 各シーケンスに対して、直前に採番された最新値を取得クラス
 */
public interface SelectSeqLastValueMapper {

    /**
     * シーケンスから、直前に採番された最新値を取得する
     *
     * @return シーケンスの最新値
     */
    public Integer selectLastValue();

}