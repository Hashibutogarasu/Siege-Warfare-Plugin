package com.hashibutogarasu.siege_warfare_plugin.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;


import static org.bukkit.Bukkit.getServer;

public class teamnext {
    /**
     * サーバー内のプレイヤーリスト
     */
    public static List<? extends Player> players = getServer().getOnlinePlayers().stream().toList();

    /**
     * 現在のカウント
     */
    public static int count = 0;

    /**
     * 鯖にいるプレイヤー数
     */
    public static int maxcount = 0;

    /**
     * プレイヤーの名前
     */
    private static String playername = "";

    /**
     * Send next rawtext to sender
     * rawtextを送るやつクリックするとチームに入れる
     * 単純にループ文だと見にくくなるのでステップ形式にした
     * @return void
     */
    public static boolean run(CommandSender sender, Command cmd, String commandLabel, String[] args){
        try {
            if (sender.isOp() && players.size() != 0) {

                players = getServer().getOnlinePlayers().stream().toList();
                playername = players.get(count).getName();
                maxcount = players.size();

                /**
                 *{@link players}または{@link playername}がnull
                 * または{@link maxcount}が0
                 * または{@link count}が{@link maxcount}以上の場合
                 */
                if (players == null || playername == null || maxcount == 0 || count >= maxcount) {
                    /**
                     * カウントが上限に達したときに送るメッセージ
                     */
                    getServer().dispatchCommand(getServer().getConsoleSender(),
                            "tellraw " + sender.getName() + " [\"\",{\"text\":\"[\"},{\"text\":\"INFO\",\"color\":\"blue\"},{\"text\":\"] \\u30c1\\u30fc\\u30e0\\u306e\\u8a2d\\u5b9a\\u304c\\u5b8c\\u4e86\\u3057\\u307e\\u3057\\u305f\"}]"
                    );
                    return true;
                }

                /**
                 * rawtextを送る「[PlayerName] 赤チームに追加 青チームに追加 チーム状態をリセット 次へ」
                 */
                getServer().dispatchCommand(getServer().getConsoleSender(),
                        "tellraw " + sender.getName() + " [\"\",{\"text\":\"[\"},{\"text\":\"" + playername + "\",\"color\":\"yellow\"},{\"text\":\"] \"},{\"text\":\"赤チームに追加\\u2690\",\"underlined\":true,\"color\":\"red\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/team join red " + playername + "\"}},{\"text\":\" \"},{\"text\":\"青チームに追加\\u2690\",\"underlined\":true,\"color\":\"blue\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/team join blue " + playername + "\"}},{\"text\":\" \"},{\"text\":\"チーム状態をリセット×\",\"underlined\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/team leave " + playername + "\"" + "}},{\"text\":\" \"},{\"text\":\"次へ\",\"underlined\":true,\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/teamnext\"}}]"
                );

                /**
                 * カウントを増やす（プレイヤーをリストから参照する時に使う）
                 */
                count++;

                return true;
            } else if (count == maxcount) {
                /**
                 * カウントが上限に達したときに送るメッセージ
                 */
                getServer().dispatchCommand(getServer().getConsoleSender(),
                        "tellraw " + sender.getName() + " [\"\",{\"text\":\"[\"},{\"text\":\"INFO\",\"color\":\"blue\"},{\"text\":\"] \\u30c1\\u30fc\\u30e0\\u306e\\u8a2d\\u5b9a\\u304c\\u5b8c\\u4e86\\u3057\\u307e\\u3057\\u305f\"}]"
                );

                return true;
            } else {
                /**
                 * 送信者がOPではないまたはサーバーに誰もいないときのメッセージ
                 */
                sender.sendMessage("プレイヤーがいないかまたは権限がありません");

                return false;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
