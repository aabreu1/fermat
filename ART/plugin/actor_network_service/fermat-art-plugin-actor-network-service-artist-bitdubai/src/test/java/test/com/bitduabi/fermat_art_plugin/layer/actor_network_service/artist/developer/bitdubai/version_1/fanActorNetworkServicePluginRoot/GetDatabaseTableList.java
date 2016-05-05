package test.com.bitduabi.fermat_art_plugin.layer.actor_network_service.artist.developer.bitdubai.version_1.fanActorNetworkServicePluginRoot;

import com.bitdubai.fermat_api.layer.all_definition.developer.DeveloperDatabase;
import com.bitdubai.fermat_api.layer.all_definition.developer.DeveloperDatabaseTable;
import com.bitdubai.fermat_api.layer.all_definition.developer.DeveloperObjectFactory;
import com.bitdubai.fermat_art_plugin.layer.actor_network_service.artist.developer.bitdubai.version_1.ArtistActorNetworkServicePluginRoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.mockito.Mockito.when;

/**
 * Created by gianco on 03/05/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class GetDatabaseTableList {

    @Test
    public void getDatabaseTableList(){
        DeveloperObjectFactory developerObjectFactory = null;

        DeveloperDatabase developerDatabase = null;

        ArtistActorNetworkServicePluginRoot artistActorNetworkServicePluginRoot = Mockito.mock(ArtistActorNetworkServicePluginRoot.class);

        List<DeveloperDatabaseTable> developerDatabaseTable = new List<DeveloperDatabaseTable>() {

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<DeveloperDatabaseTable> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(DeveloperDatabaseTable developerDatabaseTable) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends DeveloperDatabaseTable> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends DeveloperDatabaseTable> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public DeveloperDatabaseTable get(int index) {
                return null;
            }

            @Override
            public DeveloperDatabaseTable set(int index, DeveloperDatabaseTable element) {
                return null;
            }

            @Override
            public void add(int index, DeveloperDatabaseTable element) {

            }

            @Override
            public DeveloperDatabaseTable remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<DeveloperDatabaseTable> listIterator() {
                return null;
            }

            @Override
            public ListIterator<DeveloperDatabaseTable> listIterator(int index) {
                return null;
            }

            @Override
            public List<DeveloperDatabaseTable> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        when(artistActorNetworkServicePluginRoot.getDatabaseTableList(developerObjectFactory, developerDatabase)).thenReturn(developerDatabaseTable);

    }
}
