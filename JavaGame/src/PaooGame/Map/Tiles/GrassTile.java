package PaooGame.Map.Tiles;

import PaooGame.Graphics.Assets;

/*! \class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class GrassTile extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public GrassTile(int id)
    {
            /// Apel al constructorului clasei de baza
        super(Assets.grass, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
