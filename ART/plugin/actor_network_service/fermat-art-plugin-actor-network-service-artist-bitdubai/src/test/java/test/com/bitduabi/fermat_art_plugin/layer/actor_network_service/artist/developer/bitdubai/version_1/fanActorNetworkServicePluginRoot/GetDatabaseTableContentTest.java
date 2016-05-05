package test.com.bitduabi.fermat_art_plugin.layer.actor_network_service.artist.developer.bitdubai.version_1.fanActorNetworkServicePluginRoot;

import com.bitdubai.fermat_api.layer.all_definition.developer.DeveloperDatabase;
import com.bitdubai.fermat_api.layer.all_definition.developer.DeveloperDatabaseTable;
import com.bitdubai.fermat_api.layer.all_definition.developer.DeveloperDatabaseTableRecord;
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
public class GetDatabaseTableContentTest {

    @Test
    public void getDatabaseTableContentTest(){
        DeveloperObjectFactory developerObjectFactory = null;
        DeveloperDatabase developerDatabase = null;
        DeveloperDatabaseTable developerDatabaseTable = null;

        ArtistActorNetworkServicePluginRoot artistActorNetworkServicePluginRoot = Mockito.mock(ArtistActorNetworkServicePluginRoot.class);

        List<DeveloperDatabaseTableRecord> developerDatabaseTableRecord = new List<DeveloperDatabaseTableRecord>() {
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
            public Iterator<DeveloperDatabaseTableRecord> iterator() {
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
            public boolean add(DeveloperDatabaseTableRecord developerDatabaseTableRecord) {
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
            public boolean addAll(Collection<? extends DeveloperDatabaseTableRecord> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends DeveloperDatabaseTableRecord> c) {
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
            public DeveloperDatabaseTableRecord get(int index) {
                return null;
            }

            @Override
            public DeveloperDatabaseTableRecord set(int index, DeveloperDatabaseTableRecord element) {
                return null;
            }

            @Override
            public void add(int index, DeveloperDatabaseTableRecord element) {

            }

            @Override
            public DeveloperDatabaseTableRecord remove(int index) {
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
            public ListIterator<DeveloperDatabaseTableRecord> listIterator() {
                return null;
            }

            @Override
            public ListIterator<DeveloperDatabaseTableRecord> listIterator(int index) {
                return null;
            }

            @Override
            public List<DeveloperDatabaseTableRecord> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        when(artistActorNetworkServicePluginRoot.getDatabaseTableContent(developerObjectFactory, developerDatabase, developerDatabaseTable)).thenReturn(developerDatabaseTableRecord);


    }

}
